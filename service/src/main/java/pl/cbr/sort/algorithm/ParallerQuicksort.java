package pl.cbr.sort.algorithm;

import pl.cbr.sort.SortBase;

import java.util.*;
import java.util.concurrent.*;

public class ParallerQuicksort<T extends Comparable<T>> extends SortBase<T> {

    static final int INSERTION_SORT_LIMIT = 18;
    static final int PARALLER_SORT_LIMIT = 2*1024;
    static final int ZERO = 0;

    ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    Map<Future<Integer>, Integer> tasks = new ConcurrentHashMap<>();
    

    @Override
    public void sort(T[] data) {
        int left = 0;
        int right = data.length - 1;

        int os = division(data, left, right);

        tasks.put(executor.submit(() -> {
            quickSort(data, left, os - 1);
            return 0;
        }),0);

        quickSort(data,os + 1, right);

        try {
            while(tasks.size() > 0) {
                tasks.keySet().stream().filter(task -> task.isDone()).forEach(task -> tasks.remove(task));
                Thread.sleep(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void quickSort(T data[], int left, int right) {
        if ( left<right ) {
            int difference = right - left;
            if ( difference < INSERTION_SORT_LIMIT ) {
                insertionSort(data, left, right);
            } else {
                int os  = division(data,left,right);

                if ( (os-left) < PARALLER_SORT_LIMIT ) {
                    quickSort(data, left, os - 1);
                } else {
                    tasks.put(executor.submit(() -> {
                        quickSort(data, left, os - 1);
                        return 1;
                    }),1);
                }

                if ( (right-os) < PARALLER_SORT_LIMIT ) {
                    quickSort(data, os + 1, right);
                } else {
                    tasks.put(executor.submit(() -> {
                        quickSort(data, os + 1, right);
                        return 1;
                    }),1);
                }
            }
        }
    }

    int division(T data[], int left, int right ) {
        int o = (right+left)/2;

        swap(data,o,right);
        int stored   = left;

        for ( int i=left; i<right; i++ ) {
            if ( (data[i]).compareTo(data[right]) < ZERO ) {
                swap(data,i, stored);
                stored++;
            }
        }
        swap(data,stored,right);

        return stored;
    }

    void swap(T data[], int a,int b) {
        T tmp1 = data[a];
        data[a] = data[b];
        data[b] = tmp1;
    }

    void insertionSort(T data[], int left, int right) {
        for ( int j = left + 1; j <= right; j++) {
            int i = j - 1;
            T value = data[j];
            while(i >= left && data[i].compareTo(value) > ZERO ) {
                data[i+1] = data[i];
                i--;
            }
            data[i+1] = value;
        }
    }
}
