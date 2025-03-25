package pl.cbr.sort.algorithm;


import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import pl.cbr.sort.GenericSortTool;
import pl.cbr.sort.SortBase;

import java.util.Arrays;
import java.util.stream.IntStream;

public class QuicksortGenericPerformanceTest {
		
//	public int SAMPLE_SIZE = 10000000;
	public int SAMPLE_SIZE = 1000000;

	GenericSortTool<Integer> tool;
	Integer[]  arrInteger;

	public QuicksortGenericPerformanceTest() {
		tool = new GenericSortTool<>();
		arrInteger  = new Integer[SAMPLE_SIZE];
		IntStream.range(0,arrInteger.length).forEach(i->arrInteger[i]=(int)((Math.random())*Integer.MAX_VALUE ));
	}

	@Test
	public void testQuicksortSimpleInteger() {
		SortBase<Integer>   sort = new QuicksortSimple<>();
    	GenericSortTool<Integer> tool = new GenericSortTool<>();
		Integer[]  arr  = Arrays.copyOf(arrInteger, arrInteger.length);
        long t1 = System.currentTimeMillis();
        sort.sort(arr);
        long t2 = System.currentTimeMillis();
		Assert.assertTrue("Not sorted", tool.test(arr));
		System.out.println(sort.getClass().getSimpleName() + " (Integer):" + (t2-t1) +"ms");
	}

	@Test 
	public void testQuicksortInteger() {
		SortBase<Integer>   sort = new Quicksort<>();
    	GenericSortTool<Integer> tool = new GenericSortTool<>();
		Integer[]  arr  = Arrays.copyOf(arrInteger, arrInteger.length);
        long t1 = System.currentTimeMillis();
        sort.sort(arr);
        long t2 = System.currentTimeMillis();
		Assert.assertTrue("Not sorted", tool.test(arr));
		System.out.println(sort.getClass().getSimpleName() + " (Integer):" + (t2-t1) +"ms");
	}

	@Test
	public void testQuicksortFastInteger() {
		SortBase<Integer>   sort = new QuicksortFast<>();
		GenericSortTool<Integer> tool = new GenericSortTool<>();
		Integer[]  arr  = Arrays.copyOf(arrInteger, arrInteger.length);
		long t1 = System.currentTimeMillis();
		sort.sort(arr);
		long t2 = System.currentTimeMillis();
		Assert.assertTrue("Not sorted", tool.test(arr));
		System.out.println(sort.getClass().getSimpleName() + " (Integer):" + (t2-t1) +"ms");
	}


	@Test
	public void testQuicksortDualPivotInteger() {
		SortBase<Integer>   sort = new QuicksortDualPivot<>();
		GenericSortTool<Integer> tool = new GenericSortTool<>();
		Integer[]  arr  = Arrays.copyOf(arrInteger, arrInteger.length);
		long t1 = System.currentTimeMillis();
		sort.sort(arr);
		long t2 = System.currentTimeMillis();
		Assert.assertTrue("Not sorted", tool.test(arr));
		System.out.println(sort.getClass().getSimpleName() + " (Integer):" + (t2-t1) +"ms");
	}

	@Ignore
	@Test
	public void testQuickfireInteger() {
		SortBase<Integer>   sort = new Quickfire<>();
		GenericSortTool<Integer> tool = new GenericSortTool<>();
		Integer[]  arr  = Arrays.copyOf(arrInteger, arrInteger.length);
		long t1 = System.currentTimeMillis();
		sort.sort(arr);
		long t2 = System.currentTimeMillis();
		Assert.assertTrue("Not sorted", tool.test(arr));
		System.out.println(sort.getClass().getSimpleName() + " (Integer):" + (t2-t1) +"ms");
	}

	@Test
	public void testSystemSort() {
    	SortBase<Integer>   sort = new SystemSort<>();
    	GenericSortTool<Integer> tool = new GenericSortTool<>();
		Integer[]  arr  = Arrays.copyOf(arrInteger, arrInteger.length);
		long t1 = System.currentTimeMillis();
        sort.sort(arr);
        long t2 = System.currentTimeMillis();
		Assert.assertTrue("Not sorted", tool.test(arr));
		System.out.println(sort.getClass().getSimpleName() + " (Integer):" + (t2-t1) +"ms");
	}

	@Ignore
	@Test 
	public void testSortFloat() {
		SortBase<Float>   sort = new QuicksortSimple<>();
    	GenericSortTool<Float> tool = new GenericSortTool<>();
        int size    = SAMPLE_SIZE;
        Float[]  arr  = new Float[size];
        IntStream.range(0,arr.length).forEach(i->arr[i]=(float)((Math.random())*10000 ));
        long t1 = System.currentTimeMillis();
        sort.sort(arr);
        long t2 = System.currentTimeMillis();
        Assert.assertTrue("Not sorted", tool.test(arr));
		System.out.println(sort.getClass().getSimpleName() + " (Float):" + (t2-t1) +"ms");
	}

	@Ignore
	@Test
	public void testInsertionSort() {
    	SortBase<Integer>   sort = new InsertionSort<>();
    	GenericSortTool<Integer> tool = new GenericSortTool<>();
        int size    = SAMPLE_SIZE;
    	Integer[]  arr  = new Integer[size];
        IntStream.range(0,arr.length).forEach(i->arr[i]=(int)((Math.random())*100 ));
        long t1 = System.currentTimeMillis();
//        tool.print(arr);
        sort.sort(arr);
  //      tool.print(arr);
        long t2 = System.currentTimeMillis();
		Assert.assertTrue("Not sorted", tool.test(arr));
		System.out.println(sort.getClass().getSimpleName() + " (Integer):" + (t2-t1) +"ms");
	}
}
