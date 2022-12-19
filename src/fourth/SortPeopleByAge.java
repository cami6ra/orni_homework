package fourth;

import java.util.ArrayList;
import java.util.Comparator;

public class SortPeopleByAge implements Sortable{

    @Override
    public void sort(ArrayList<Person> people) {
        people.sort(Comparator.comparing(Person::getAge));
    }
}
