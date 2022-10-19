import java.net.Socket;

public class MyArrayList<T> {
    private final int DEFAUL_CAPACITY = 16;
    private Object[] array = new Object[DEFAUL_CAPACITY];
    private int size = 0;


    public void add(T item) {
        if (size == array.length-1) {
            resize();
        }
        array[size++] = item;
    }

    public T get(int index) {
        T t = null;
            if(index < array.length - 1) {
                t = (T) array[index];
            }
        return t;
    }

    public void resize() {
        Object[] newArray = new Object[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    public int size() {
        return size;
    }


    public void remove(int index) {
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        array[size] = null;
        size--;
    }

}
