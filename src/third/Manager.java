package third;

public class Manager {

    public void sort(SeniorStorekeeper seniorStorekeeper){
        System.out.println("\nПМ: «Отсортируешь пузырьком, милорд?»");
        seniorStorekeeper.bubbleSort();
        System.out.println("\nПМ: «В таком случае сделай так, как считаешь нужным.»");
        seniorStorekeeper.mergeSort();
    }

    public void sort(JuniorStorekeeper juniorStorekeeper){
        System.out.println("\nПМ: «Отсортируешь пузырьком, джун?»");
        juniorStorekeeper.bubbleSort();
        System.out.println("\nПМ: «Это все замечательно. Но заказчик поменял требования и нужно отсортировать слиянием!»");
        juniorStorekeeper.mergeSort();
    }

    public void makeSense(){
        System.out.println("\nПМ: «Зачем я здесь?..»");
    }
}
