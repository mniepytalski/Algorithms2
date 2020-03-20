package pl.cbr.sort.algorithm;

import pl.cbr.sort.SortBase;

public class QuicksortFast<T extends Comparable<T>> extends SortBase<T> {

    static final int ZERO = 0;
    static final int INSERTION = 18;

    @Override
    public void sort(T data[]) {
        quickSort(data,0,data.length-1);
    }

    private void quickSort(T data[], int left, int right) {
        if ( left<right ) {
            if ( (right-left) < INSERTION ) {

                insertionSort(data, left, right);

            } else {
                int os  = division(data,left,right);
                quickSort(data,left,os-1);
                quickSort(data,os+1,right);
            }
        }
    }

    int division(T data[], int left, int right ) {
        int o = (right+left)>>1;

        T tmp = data[o];
        data[o] = data[right];
        data[right] = tmp;

        int stored   = left;

        for ( int i=left; i<right; i++ ) {
            if ( (data[i]).compareTo(data[right]) < ZERO ) {

                tmp = data[i];
                data[i] = data[stored];
                data[stored] = tmp;

                stored++;
            }
        }
        tmp = data[stored];
        data[stored] = data[right];
        data[right] = tmp;

        return stored;
    }

    void insertionSortFast(T data[], int left, int right) {
        T tmp;
        for ( int i = left + 1; i <= right; i++) {
            for ( int j = i; j>left && data[j].compareTo(data[j-1]) < ZERO; j--) {
                tmp = data[j];
                data[j] = data[j-1];
                data[j-1] = tmp;
            }
        }
    }

    void insertionSort(T data[], int left, int right) {

        for ( int j = left + 1; j <= right; j++) {
            int i = j - 1;
            while(i >= left && data[i].compareTo(data[j]) > ZERO ) {
                data[i+1] = data[i];
                i--;
            }
            data[i+1] = data[j];
        }
    }


}
