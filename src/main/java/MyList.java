
public interface MyList<T> {
     boolean add(T item);
     boolean remove(Object o);
     void clear();
     T get(int index);
     T set(int index, T element);
     void add(int index, T element);
     T remove(int index);
     int size();
     boolean isEmpty();
     boolean contains(Object o);
     int indexOf(Object o);
     MyList<T> subList(int fromIndex, int toIndex);


}
