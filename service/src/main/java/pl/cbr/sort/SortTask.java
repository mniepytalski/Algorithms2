package pl.cbr.sort;

public class SortTask {

    Object[] data;
    int left;
    int right;
    boolean busy;

    public SortTask(Object[] data, int left, int right) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.busy = false;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;

    }
    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    public Object[] getData() {
        return data;
    }

    public boolean isBusy() {
        return busy;
    }

    @Override
    public String toString() {
        return "SortTask{"
                + "left=" + left
                + ", right=" + right
                + ", busy=" + busy
                + '}';
    }
}
