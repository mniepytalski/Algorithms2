package pl.cbr.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.rules.TestRule;

import pl.cbr.sort.*;

public class SortTest {
	
    @Rule
    public TestName name = new TestName();
	
	int data[];
	
	@Before
	public void before() {
		System.out.println("before");
		Sort sort = new Sort();
		data = sort.prepareData(50000000);
//		data = sort.prepareData(1000000);

		start();
	}
	
    private long start;

    public void start() {
        start = System.currentTimeMillis();
    }

    @After
    public void end() {
        System.out.println("Test " + name.getMethodName() + " took " + (System.currentTimeMillis() - start) + " ms");
    }	
	
	
	@Test 
	public void testSystemSortParaller() {
		Sort sort = new SystemSortParaller();	
		sort.sortuj(data);
		if ( !sort.test(data) ) {
			fail("Not sorted");
		}
	}

	
	@Test
	public void testSystemSort() {
		Sort sort = new SystemSort();	
		sort.sortuj(data);
		if ( !sort.test(data) ) {
			fail("Not sorted");
		}
	}
	
	@Test 
	public void testQuicksort() {
		Sort sort = new Quicksort();	
		sort.sortuj(data);
		if ( !sort.test(data) ) {
			fail("Not sorted");
		}
	}

}
