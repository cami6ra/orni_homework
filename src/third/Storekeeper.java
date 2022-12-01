package third;

import java.util.Arrays;

public abstract class Storekeeper {
    static int[] array = new int[10];

    // генерация массива из 10 чисел (значения от 1 до 10)
    public static int[] generateArray(){
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.round((Math.random() * 9) + 1);
        }
        System.out.println("Сгенерированный массив: " + Arrays.toString(array));

        return array;
    }

    public void bubbleSort(){

    }

    public void mergeSort(){

    }

}
