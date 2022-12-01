package third;

import java.util.Arrays;

public class SeniorStorekeeper extends JuniorStorekeeper {

    @Override
    public void bubbleSort() {
        System.out.println("*перекати-поле*");
    }

    @Override
    public void mergeSort() {
        long time = System.nanoTime();
        doMerge(array, array.length);
        time = System.nanoTime() - time;
        System.out.println("СЕНЬОР: «Ничего без меня не можете...»");
        System.out.printf("Сеньор отсортировал слиянием: " + Arrays.toString(array) + " за: %,9.3f ms\n", time/1_000_000.0);
    }

    public void doMerge(int[] array, int arrayLength) {
        if (arrayLength < 2) return;

        //делим массив на две части и объявляем размеры для новых массивов
        int mid = arrayLength / 2;
        int[] left = new int[mid];
        int[] right = new int[arrayLength - mid];

        //записываем половинки исходного массива в новые
        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, arrayLength - mid);

        //рекурсия
        doMerge(left, mid);
        doMerge(right, arrayLength - mid);

        merge(array, left, right, mid, arrayLength - mid);
    }

    public static void merge(int[] array, int[] left, int[] right, int leftLength, int rightLength) {
        int k = 0, i = 0, j = 0;

        while (i < leftLength && j < rightLength) {
            //если элемент из левого массива <= чем элемент второго, то добавляем в массив array
            if (left[i] <= right[j])
                array[k++] = left[i++];
            // в противном случае - добавляем элемент из правого массива в основной
            else
                array[k++] = right[j++];
        }

        while (i < leftLength) {
            array[k++] = left[i++];
        }

        while (j < rightLength) {
            array[k++] = right[j++];
        }
    }
}
