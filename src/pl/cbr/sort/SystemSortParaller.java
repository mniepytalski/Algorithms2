package pl.cbr.sort;

import java.util.Arrays;

import org.junit.Rule;
import org.junit.rules.TestRule;

public class SystemSortParaller extends Sort {
	
	@Override
	public void sortuj(int[] data) {
		Arrays.parallelSort(data);		
	}

	
	
}
