package pl.cbr.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pl.cbr.sort.*;

public class SortTest {

	
	int data[];
	
	@Before
	public void before() {
		Sort sort = new SystemSortParaller();
		data = sort.prepareData(1000000);
	}
	
	@Test
	public void test() {
		
		Sort sort = new SystemSortParaller();	
		sort.sortuj(data);
		
		if ( !sort.test(data) ) {
			fail("Not sorted");
		}

		
	}

}
