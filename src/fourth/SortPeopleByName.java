package fourth;

import java.util.ArrayList;
import java.util.Comparator;

public class SortPeopleByName implements Sortable{

    @Override
    public void sort(ArrayList<Person> people) {
        people.sort(Comparator.comparing(Person::getName));
    }
}
