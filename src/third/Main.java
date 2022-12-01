package third;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();

        manager.sort(new JuniorStorekeeper());
        manager.sort(new SeniorStorekeeper());

    }
}
