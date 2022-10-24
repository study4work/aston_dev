import java.util.List;

public class QuickSort<T extends Comparable<T>> {

    public  void quickSort(List<T> arr, int from, int to) {
        if (from < to) {
            int divideIndex = partition(arr, from, to);
            quickSort(arr, from, divideIndex - 1);
            quickSort(arr, divideIndex, to);
        }
    }

    private int partition(List<T> arr, int from, int to) {
        //индекс начала массива
        int rightIndex = to;
        //индекс конца массива
        int leftIndex = from;
        //выбирается опорный елемнт относительно которого будет начинаться сортировка
        T pivot = arr.get(from);

        while (leftIndex <= rightIndex) {
            //Двигаемся от начала массива до опорного элемента, пока не найдем элемент который меньше чем опорный.
            while (arr.get(leftIndex).compareTo(pivot) < 0) {
                leftIndex++;
            }
            //Далее ищем элемент,который больше опорного,двигаемся от конца массива до опорного элемента.
            while (arr.get(rightIndex).compareTo(pivot) > 0) {
               rightIndex--;
            }
            //после нахождения двух элементов меняем их местами.
            if(leftIndex <= rightIndex) {
                T temp = arr.get(rightIndex);
                arr.set(rightIndex, arr.get(leftIndex));
               // arr[rightIndex] = arr[leftIndex];
                arr.set(leftIndex, temp);
                // arr[leftIndex] = temp;
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }
}
