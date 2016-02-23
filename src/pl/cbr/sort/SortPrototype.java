package pl.cbr.sort;



public abstract class SortPrototype {
	
    public abstract void sortuj(int data[]);

    public abstract int[] prepareData(int size);

    public abstract void print(int data[]);
    
    public abstract boolean test(int data[]);
}
