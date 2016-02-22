package pl.cbr.sort;

import java.util.Arrays;

/**
 * Created by Mariusz on 2015-06-20.
 */
public class Quicksort extends Sort {

    public void sortuj(int data[]) {
        quickSort(data,0,data.length-1);
    }

    void quickSort(int data[], int lewy, int prawy) {
        if ( lewy<prawy ) {
            int os  = podzial(data,lewy,prawy);
            quickSort(data,lewy,os-1);
            quickSort(data,os+1,prawy);
        }
    }

    int podzial(int data[], int lewy, int prawy ) {
        int o = (prawy+lewy)/2;

        swap(data,o,prawy);
        int przechowywany   = lewy;

        for ( int i=lewy; i<prawy; i++ ) {
            if ( data[i]<=data[prawy]) {
                swap(data,i, przechowywany);
                przechowywany++;
            }
        }
        swap(data,przechowywany,prawy);

       return przechowywany;
    }

    void swap(int data[], int a,int b) {
            int tmp1 = data[a];
            data[a] = data[b];
            data[b] = tmp1;
    }

    public static void main(String[] args) {
        Quicksort   sort = new Quicksort();

        int size    = 50000000;

        int arr[] = sort.prepareData(size);
//        sort.print(arr);
        long t1 = System.currentTimeMillis();
        sort.sortuj(arr);
        long t2 = System.currentTimeMillis();
//        sort.print(arr);
        System.out.println("1> calc time: " + (t2 - t1) + "ms");

        arr = sort.prepareData(size);
        t1 = System.currentTimeMillis();
        Arrays.sort(arr);
        t2 = System.currentTimeMillis();
//        sort.print(arr);
        System.out.println("2> calc time: "+(t2-t1)+"ms");

        System.exit(0);
    }
}
