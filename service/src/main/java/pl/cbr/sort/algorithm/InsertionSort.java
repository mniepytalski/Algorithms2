package pl.cbr.sort.algorithm;

import pl.cbr.sort.SortBase;

public class InsertionSort <T extends Comparable<T>> extends SortBase<T> {

	@Override
	public void sort(T data[]) {
		for ( int j = 1; j<data.length; j++) {
			int i = j - 1;
			T value = data[j];
			while(i >= 0 && data[i].compareTo(value) > 0 ) {
				data[i+1] = data[i];
				i--;
			}
			data[i+1] = value;
		}
	}

}
