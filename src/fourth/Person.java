package fourth;

public class Person {
    String name;
    int age;
    String[] names = {"Александр", "Антон", "Герман", "Дамир", "Дарина", "Камила", "Камиль", "Карина", "Константин", "Надежда", "Мария", "Мужык", "Ленар", "Юлия"};

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Person generatePerson() {
        return new Person(names[(int) Math.round((Math.random() * 13))], (int) Math.round((Math.random() * 99) + 1));
    }
}
