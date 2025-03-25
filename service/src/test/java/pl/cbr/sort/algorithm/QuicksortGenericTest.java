package pl.cbr.sort.algorithm;


import org.junit.Ignore;
import org.junit.Test;
import pl.cbr.sort.GenericSortTool;
import pl.cbr.sort.SortBase;

import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.Assert.assertTrue;

public class QuicksortGenericTest {
		
	public int SAMPLE_SIZE = 100;

	@Ignore
	@Test
	public void testQuickfire() {
		SortBase<Integer>   sort = new Quickfire<>();
		GenericSortTool<Integer> tool = new GenericSortTool<>();
		Integer  arr[]  = generateRandomIntegerArray(SAMPLE_SIZE, Integer.MAX_VALUE);
		sort.sort(arr);
		assertTrue("Not sorted", tool.test(arr));
	}


	@Test 
	public void testSortInteger() {
		SortBase<Integer>   sort = new QuicksortSimple<>();
    	GenericSortTool<Integer> tool = new GenericSortTool<>();
    	Integer  arr[]  = generateRandomIntegerArray(SAMPLE_SIZE, Integer.MAX_VALUE);
		sort.sort(arr);
		assertTrue("Not sorted", tool.test(arr));
	}

	@Test 
	public void testSortInteger2() {
		SortBase<Integer>   sort = new Quicksort<>();
    	GenericSortTool<Integer> tool = new GenericSortTool<>();
    	Integer  arr[]  = generateRandomIntegerArray(SAMPLE_SIZE, Integer.MAX_VALUE);
		sort.sort(arr);
		assertTrue("Not sorted", tool.test(arr));
	}

	@Test
	public void testSystemSort() {
    	SortBase<Integer>   sort = new SystemSort<>();
    	GenericSortTool<Integer> tool = new GenericSortTool<>();
    	Integer  arr[]  = generateRandomIntegerArray(SAMPLE_SIZE, Integer.MAX_VALUE);
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
		Integer[] arr = generateRandomIntegerArray(SAMPLE_SIZE, 100);
		sort.sort(arr);
		assertTrue("Not sorted", tool.test(arr));
	}

	private Integer[] generateRandomIntegerArray(int size, int amplitude) {
		return IntStream.generate(() -> new Random().nextInt(amplitude))
				.limit(size)
				.boxed()
				.toArray(Integer[]::new);
	}

}
