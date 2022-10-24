
public class MyArrayList<T> implements MyList<T> {

    private final int DEFAUL_CAPACITY = 16;
    private Object[] array = new Object[DEFAUL_CAPACITY];
    private int size = 0;

    @Override
    public boolean add(T item) {
        if (size == array.length-1) {
            resize();
        }
        array[size++] = item;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Object[] newArray = array;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(o)) {
                System.arraycopy(array, i + 1, newArray, i, (array.length - (i + 1)));
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        array = new Object[size];
        size = 0;
    }

    @Override
    public T get(int index) {
        T t = null;
        if(index < array.length - 1) {
            t = (T) array[index];
        }
        return t;
    }

    @Override
    public T set(int index, T element) {
        Object result = null;
        if (index < array.length) {
            result = array[index];
            array[index] = element;

        }
        return (T) result;
    }

    @Override
    public void add(int index, T element) {
        if (index < array.length) {
            array[index] = element;
        }
    }

    @Override
    public T remove(int index) {
        Object[] newArray = array;
        System.arraycopy(array, index + 1, newArray, index, (array.length - (index + 1)));
        size--;
        return (T)array[index];
    }

    public void resize() {
        Object[] newArray = new Object[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        boolean result = false;
        for (int i = 0; i < size; i++) {
            if (array[i].equals(o)) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(o)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public MyList<T> subList(int fromIndex, int toIndex) {
        MyList<T> list = new MyArrayList<>();
        for (int i = fromIndex; i <= toIndex; i++) {
            list.add((T) array[i]);
        }
        return list;
    }

}
