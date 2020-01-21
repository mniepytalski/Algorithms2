package pl.cbr.sort.algorithm;

import java.util.Arrays;

import pl.cbr.sort.SortBase;

public class SystemSort <T extends Comparable<T>> extends SortBase<T> {

	@Override
	public void sort(T[] data) {
		Arrays.sort(data);
	}

}
