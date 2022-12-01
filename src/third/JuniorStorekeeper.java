package third;

import java.util.Arrays;

public class JuniorStorekeeper extends Storekeeper{

    static int[] array = generateArray();

    @Override
    public void mergeSort() {
        System.out.println("ДЖУН: «Я не умею, научишь?)))))»");
    }

    //сортировка пузырьком
    public void bubbleSort(){

        //замер времени
        long time = System.nanoTime();

        boolean isSorted = false;
        int buf;

        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length-1; i++) {
                if(array[i] > array[i+1]){
                    isSorted = false;

                    buf = array[i];
                    array[i] = array[i+1];
                    array[i+1] = buf;
                }
            }
        }
        time = System.nanoTime() - time;
        // 3 знака после запятой
        System.out.printf("Джун отсортировал пузырьком: " + Arrays.toString(array) + " за: %,9.3f ms\n", time/1_000_000.0);
    }
}
