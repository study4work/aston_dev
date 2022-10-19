
public class QuickSort {

    private void quickSort(int[] arr, int from, int to) {
        if (from < to) {
            int divideIndex = partition(arr, from, to);
            quickSort(arr, from, divideIndex - 1);
            quickSort(arr, divideIndex, to);
        }
    }

    private int partition(int[] arr, int from, int to) {
        //индекс начала массива
        int rightIndex = to;
        //индекс конца массива
        int leftIndex = from;
        //выбирается опорный елемнт относительно которого будет начинаться сортировка
        int pivot = arr[from];

        while (arr[leftIndex] <= arr[rightIndex]) {
            //Двигаемся от начала массива до опорного элемента, пока не найдем элемент который меньше чем опорный.
            while (arr[leftIndex] < pivot) {
                leftIndex++;
            }
            //Далее ищем элемент,который больше опорного,двигаемся от конца массива до опорного элемента.
            while (arr[rightIndex] > pivot) {
               rightIndex--;
            }
            //после нахождения двух элементов меняем их местами.
            if(leftIndex <= rightIndex) {
                int temp = arr[rightIndex];
                arr[rightIndex] = arr[leftIndex];
                arr[leftIndex] = temp;
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    public static void main(String[] args) {
        int[] arr = {34, 66, 11, 42, 54, 35, 88};
        QuickSort q = new QuickSort();
        q.quickSort(arr, 0, arr.length-1);
        for (int i: arr) {
            System.out.print(i + " ");
        }
    }
}
