package pl.cbr.sort.algorithm;


import static org.junit.Assert.assertTrue;

import java.util.stream.IntStream;

import org.junit.Ignore;
import org.junit.Test;

import pl.cbr.sort.GenericSortTool;
import pl.cbr.sort.SortBase;
import pl.cbr.sort.algorithm.QuicksortSimple;

public class QuicksortGenericPerformanceTest {
		
	public int SAMPLE_SIZE = 1000000;

	@Test 
	public void testSortInteger() {
		SortBase<Integer>   sort = new QuicksortSimple<Integer>();
    	GenericSortTool<Integer> tool = new GenericSortTool<Integer>();
        int size    = SAMPLE_SIZE;
    	Integer  arr[]  = new Integer[size];
        IntStream.range(0,arr.length).forEach(i->arr[i]=(int)((Math.random())*Integer.MAX_VALUE ));
        long t1 = System.currentTimeMillis();
        sort.sort(arr);
        long t2 = System.currentTimeMillis();
		assertTrue("Not sorted", tool.test(arr));
		System.out.println(sort.getClass().getSimpleName() + " (Integer):" + (t2-t1) +"ms");
	}

	@Test 
	public void testSortInteger2() {
		SortBase<Integer>   sort = new Quicksort<Integer>();
    	GenericSortTool<Integer> tool = new GenericSortTool<Integer>();
        int size    = SAMPLE_SIZE;
    	Integer  arr[]  = new Integer[size];
        IntStream.range(0,arr.length).forEach(i->arr[i]=(int)((Math.random())*Integer.MAX_VALUE ));
        long t1 = System.currentTimeMillis();
        sort.sort(arr);
        long t2 = System.currentTimeMillis();
		assertTrue("Not sorted", tool.test(arr));
		System.out.println(sort.getClass().getSimpleName() + " (Integer):" + (t2-t1) +"ms");
	}

	@Test
	public void testSystemSort() {
    	SortBase<Integer>   sort = new SystemSort<Integer>();
    	GenericSortTool<Integer> tool = new GenericSortTool<Integer>();
        int size    = SAMPLE_SIZE;
    	Integer  arr[]  = new Integer[size];
        IntStream.range(0,arr.length).forEach(i->arr[i]=(int)((Math.random())*Integer.MAX_VALUE ));
        long t1 = System.currentTimeMillis();
        sort.sort(arr);
        long t2 = System.currentTimeMillis();
		assertTrue("Not sorted", tool.test(arr));
		System.out.println(sort.getClass().getSimpleName() + " (Integer):" + (t2-t1) +"ms");
	}

	@Test 
	public void testSortFloat() {
		SortBase<Float>   sort = new QuicksortSimple<Float>();
    	GenericSortTool<Float> tool = new GenericSortTool<Float>();
        int size    = SAMPLE_SIZE;
        Float  arr[]  = new Float[size];
        IntStream.range(0,arr.length).forEach(i->arr[i]=(float)((Math.random())*10000 ));
        long t1 = System.currentTimeMillis();
        sort.sort(arr);
        long t2 = System.currentTimeMillis();
        assertTrue("Not sorted", tool.test(arr));
		System.out.println(sort.getClass().getSimpleName() + " (Float):" + (t2-t1) +"ms");
	}
	
	@Ignore
	@Test
	public void testInsertionSort() {
    	SortBase<Integer>   sort = new InsertionSort<Integer>();
    	GenericSortTool<Integer> tool = new GenericSortTool<Integer>();
        int size    = SAMPLE_SIZE;
    	Integer  arr[]  = new Integer[size];
        IntStream.range(0,arr.length).forEach(i->arr[i]=(int)((Math.random())*100 ));
        long t1 = System.currentTimeMillis();
        tool.print(arr);
        sort.sort(arr);
        tool.print(arr);
        long t2 = System.currentTimeMillis();
		assertTrue("Not sorted", tool.test(arr));
		System.out.println(sort.getClass().getSimpleName() + " (Integer):" + (t2-t1) +"ms");
	}
	

}
