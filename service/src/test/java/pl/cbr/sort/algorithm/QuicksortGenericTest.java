package pl.cbr.sort.algorithm;


import static org.junit.Assert.assertTrue;

import java.util.stream.IntStream;

import org.junit.Test;

import pl.cbr.sort.GenericSortTool;
import pl.cbr.sort.SortBase;

public class QuicksortGenericTest {
		
	public int SAMPLE_SIZE = 100;

	@Test
	public void testQuicksortParaller() {
		SortBase<Integer>   sort = new ParallerQuicksort<>();
		GenericSortTool<Integer> tool = new GenericSortTool<>();
		int size    = SAMPLE_SIZE;
		Integer  arr[]  = new Integer[size];
		IntStream.range(0,arr.length).forEach(i->arr[i]=(int)((Math.random())*Integer.MAX_VALUE ));
		sort.sort(arr);
		assertTrue("Not sorted", tool.test(arr));
	}

	@Test
	public void testQuickfire() {
		SortBase<Integer>   sort = new Quickfire<>();
		GenericSortTool<Integer> tool = new GenericSortTool<>();
		int size    = SAMPLE_SIZE;
		Integer  arr[]  = new Integer[size];
		IntStream.range(0,arr.length).forEach(i->arr[i]=(int)((Math.random())*Integer.MAX_VALUE ));
		sort.sort(arr);
		assertTrue("Not sorted", tool.test(arr));
	}


	@Test 
	public void testSortInteger() {
		SortBase<Integer>   sort = new QuicksortSimple<>();
    	GenericSortTool<Integer> tool = new GenericSortTool<>();
        int size    = SAMPLE_SIZE;
    	Integer  arr[]  = new Integer[size];
        IntStream.range(0,arr.length).forEach(i->arr[i]=(int)((Math.random())*Integer.MAX_VALUE ));
        sort.sort(arr);
		assertTrue("Not sorted", tool.test(arr));
	}

	@Test 
	public void testSortInteger2() {
		SortBase<Integer>   sort = new Quicksort<>();
    	GenericSortTool<Integer> tool = new GenericSortTool<>();
        int size    = SAMPLE_SIZE;
    	Integer  arr[]  = new Integer[size];
        IntStream.range(0,arr.length).forEach(i->arr[i]=(int)((Math.random())*Integer.MAX_VALUE ));
        sort.sort(arr);
		assertTrue("Not sorted", tool.test(arr));
	}

	@Test
	public void testSystemSort() {
    	SortBase<Integer>   sort = new SystemSort<>();
    	GenericSortTool<Integer> tool = new GenericSortTool<>();
        int size    = SAMPLE_SIZE;
    	Integer  arr[]  = new Integer[size];
        IntStream.range(0,arr.length).forEach(i->arr[i]=(int)((Math.random())*Integer.MAX_VALUE ));
        sort.sort(arr);
		assertTrue("Not sorted", tool.test(arr));
	}

	@Test 
	public void testSortFloat() {
		SortBase<Float>   sort = new QuicksortSimple<>();
    	GenericSortTool<Float> tool = new GenericSortTool<>();
        int size    = SAMPLE_SIZE;
        Float  arr[]  = new Float[size];
        IntStream.range(0,arr.length).forEach(i->arr[i]=(float)((Math.random())*10000 ));
        sort.sort(arr);
//        tool.print(arr);      
        assertTrue("Not sorted", tool.test(arr));
	}
	
	@Test
	public void testInsertionSort() {
    	SortBase<Integer>   sort = new InsertionSort<>();
    	GenericSortTool<Integer> tool = new GenericSortTool<>();
        int size    = SAMPLE_SIZE;
    	Integer  arr[]  = new Integer[size];
        IntStream.range(0,arr.length).forEach(i->arr[i]=(int)((Math.random())*100 ));
        sort.sort(arr);
		assertTrue("Not sorted", tool.test(arr));
	}
	
	

}
