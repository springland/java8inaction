package net.springland.streamcollector;

import java.util.List;

public class PeopleList {
    public static List<Person> createPeople() {
        return List.of(
                new Person("Sarah" , 20),
                new Person("Sarah" , 22),
                new Person("Bob" , 20),
                new Person("Paula" , 32),
                new Person("Paul" , 32),
                new Person("Jack" , 3),
                new Person("Jack" , 72),
                new Person("Jill" , 11)


        );

    }

}
