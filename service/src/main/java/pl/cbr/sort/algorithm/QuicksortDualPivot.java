package pl.cbr.sort.algorithm;

import pl.cbr.sort.SortBase;

public class QuicksortDualPivot<T extends Comparable<T>> extends SortBase<T> {

    @Override
    public void sort(T[] data) {
        quickSort(data,0,data.length-1);
    }

    // TODO - implement dual pivots algorithm
    private void quickSort(final T[] data, final int left, final int right) {
        if ( left<right ) {
            if ( (right-left) < 18 ) {
                insertionSort(data, left, right);
            } else {
                int os  = division(data,left,right);
                quickSort(data,left,os-1);
                quickSort(data,os+1,right);
            }
        }
    }

    int divisionDualPivot(final T[] data, final int left, final int right ) {

        int third = (right+left)/3;
        int p1 = left + third;
        int p2 = right - third;
        T P1 = data[p1];
        T P2 = data[p2];

        if ( P1.compareTo(P2)<0) {
            int pTmp = p1;
            p1 = p2;
            p2 = pTmp;

            T Ptmp = P1;
            P1 = P2;
            P2 = P1;
        }

        swap(data,p1,right);
        int stored   = left;

        for ( int i=left; i<right; i++ ) {
            if ( (data[i]).compareTo(data[right]) < 0 ) {
                swap(data,i, stored);
                stored++;
            }
        }
        swap(data,stored,right);

        return stored;
    }

    int division(final T[] data, final int left, final int right ) {
        int o = (right+left)/2;

        swap(data,o,right);
        int stored   = left;

        for ( int i=left; i<right; i++ ) {
            if ( (data[i]).compareTo(data[right]) < 0 ) {
                swap(data,i, stored);
                stored++;
            }
        }
        swap(data,stored,right);

        return stored;
    }

    void swap(final T[] data, final int a, final int b) {
        T tmp1 = data[a];
        data[a] = data[b];
        data[b] = tmp1;
    }


    void insertionSort(final T[] data, final int left, final int right) {

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
