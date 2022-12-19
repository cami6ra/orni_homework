package fourth;

import java.util.ArrayList;

public class People {
    ArrayList<Person> people = new ArrayList<>();
    Person person = new Person();

    public ArrayList<Person> generatePeople(int count) {
        for (int i = 0; i < count; i++) {
            people.add(person.generatePerson());
        }
        return people;
    }
}
