package pl.cbr.sort.algorithm;

import pl.cbr.sort.SortBase;
import pl.cbr.sort.SortTask;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Quickfire<T extends Comparable<T>> extends SortBase<T> {

    Map<SortTask, Integer> tasks = new ConcurrentHashMap<>();

    ExecutorService executor = Executors.newFixedThreadPool(2);


    public void sort(T data[]) {

        quickSort(new SortTask(data, 0, data.length - 1));

        while( tasks.size() > 0) {
            for (SortTask task : tasks.keySet()) {
                if ( !task.isBusy() ) {
                    task.setBusy(true);
                    quickSort(task);
                }
            }
        }
    }

    private void quickSort(SortTask task) {
        if (task.getLeft() < task.getRight()) {
            if ((task.getRight() - task.getLeft()) < 18) {
                insertionSort((T[])task.getData(), task.getLeft(), task.getRight());
            } else {
                int os = division((T[])task.getData(), task.getLeft(), task.getRight());
                tasks.put(new SortTask(task.getData(), task.getLeft(), os - 1),0);
                tasks.put(new SortTask(task.getData(),os + 1, task.getRight()),0);
            }
        }
        tasks.remove(task);
    }

    int division(T data[], int left, int right ) {
        int o = (right+left)/2;

//        swap(data,o,right);
        T tmp1 = data[o];
        data[o] = data[right];
        data[right] = tmp1;

        int stored   = left;

        for ( int i=left; i<right; i++ ) {
            if ( (data[i]).compareTo(data[right]) < 0 ) {
//                swap(data,i, stored);
                T tmp2 = data[i];
                data[i] = data[stored];
                data[stored] = tmp2;

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
            while(i >= left && data[i].compareTo(value) > 0 ) {
                data[i+1] = data[i];
                i--;
            }
            data[i+1] = value;
        }
    }

}
