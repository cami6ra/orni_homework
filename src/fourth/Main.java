package fourth;

import java.util.ArrayList;

public class Main {

    private static final int count = 5;
    private static final People people = new People();
    private static final ArrayList<Person> generatedPeople = people.generatePeople(count);

    public static void printPeople(){
        for (int i = 0; i < count; i++){
            System.out.println("Имя: " + generatedPeople.get(i).getName() + ", возраст: " + generatedPeople.get(i).getAge());
        }
        System.out.println("-----------------------------");
    }

    public static void main(String[] args) {

        System.out.println("Неотсортированный список:");
        printPeople();

        Sortable sortByAge = new SortPeopleByAge();
        sortByAge.sort(generatedPeople);

        System.out.println("Сортировка по возрасту:");
        printPeople();

        Sortable sortByName = new SortPeopleByName();
        sortByName.sort(generatedPeople);

        System.out.println("Сортировка по имени:");
        printPeople();
    }
}
