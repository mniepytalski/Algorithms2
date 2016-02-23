package pl.cbr.sort;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SortParaller extends SortPrototype {

	
    public void sortuj(int data[]) {
    	
    };

    public int[] prepareData(int size) {
        int  data[]  = new int[size];
        prepareData(data,0,data.length);
        return data;
    }
    
    void prepareData(int data[],int a1, int a2) {
        IntStream.range(a1,a2).forEach(i->data[i]=(int)((Math.random())*Integer.MAX_VALUE ));
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
