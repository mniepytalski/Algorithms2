package pl.cbr.sort;

import java.util.Arrays;

public class SystemSortParaller extends Sort {

	@Override
	public void sortuj(int[] data) {
		Arrays.parallelSort(data);		
	}

	
	
}
