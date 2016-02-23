package pl.cbr.sort;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by Mariusz on 2015-06-20.
 */
public class Sort extends SortPrototype {

    public void sortuj(int data[]) {
    	
    };

    public int[] prepareData(int size) {
        int  data[]  = new int[size];
        IntStream.range(0,data.length).forEach(i->data[i]=(int)((Math.random())*Integer.MAX_VALUE ));
        return data;
    }

    public void print(int data[]) {
        Arrays.stream(data).forEach(v -> System.out.println(v));
    }
    
    public boolean test(int data[]) {
        for ( int i=0; i<data.length-1; i++ ) {
            if ( data[i] > data[i+1] ) {
            	return false;
            }
        }
    	
    	return true;
    }

}
