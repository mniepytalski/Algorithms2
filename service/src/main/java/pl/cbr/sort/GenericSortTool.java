package pl.cbr.sort;

import java.util.Arrays;

public class GenericSortTool<T extends Comparable<T>> {
	
    public void print(T[] data) {
        Arrays.stream(data).forEach(v -> {
        	System.out.print(v);
        	System.out.print(",");
        }
        
        		);
        System.out.println();
    }
    
    public boolean test(T[] data) {
        for ( int i=0; i<data.length-1; i++ ) {
            if ( data[i].compareTo(data[i+1])>0 ) {
            	return false;
            }
        }
    	return true;
    }
    
}
