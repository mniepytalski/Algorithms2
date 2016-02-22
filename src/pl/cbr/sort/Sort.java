package pl.cbr.sort;

/**
 * Created by Mariusz on 2015-06-20.
 */
public class Sort {

    public void sortuj(int data[]) {
    	
    };

    public int[] prepareData(int size) {
        int  data[]  = new int[size];
        for ( int i=0; i<size; i++ ) {
            data[i] = (int)((Math.random())*Integer.MAX_VALUE);
        }
        return data;
    }

    public void print(int data[]) {
        for ( int i=0; i<data.length; i++ ) {
            if ( i%20==0 )
                System.out.println();
            System.out.print(data[i]+",");
        }
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
