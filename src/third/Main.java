package third;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        JuniorStorekeeper juniorStorekeeper = new JuniorStorekeeper();

        manager.askForBubbleSort();
        //джун сортирует пузырьком
        juniorStorekeeper.bubbleSort();

        SeniorStorekeeper seniorStorekeeper = new SeniorStorekeeper();

        manager.askForBubbleSort();
        //сеньор не хочет сортировать пузырьком
        seniorStorekeeper.bubbleSort();

        manager.askForMergeSort();

        //сеньор сортирует слиянием
        seniorStorekeeper.doMerge();

    }
}
