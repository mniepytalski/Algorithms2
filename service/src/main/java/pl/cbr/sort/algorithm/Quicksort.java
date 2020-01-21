package pl.cbr.sort.algorithm;

import pl.cbr.sort.SortBase;

public class Quicksort <T extends Comparable<T>> extends SortBase<T> {

	@Override
	public void sort(T data[]) {
        quickSort(data,0,data.length-1);
    }

    private void quickSort(T data[], int left, int right) {
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

    private int division(T data[], int left, int right ) {
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

    private void swap(T data[], int a,int b) {
            T tmp1 = data[a];
            data[a] = data[b];
            data[b] = tmp1;
    }
    
    
	public void insertionSort(T data[], int left, int right) {

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
