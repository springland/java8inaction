package net.springland.streamcollector;

import org.junit.Test;

import java.util.List;

public class CommonOperations {


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

    @Test
    public void printAllPeople() {

        List<Person>  people = createPeople();
        people.stream().forEach(System.out::println);

    }
    @Test
    public void printAllPeopleOldThan30()
    {
        List<Person> people = createPeople();
        people.stream().filter( person -> person.age >30).forEach(System.out::println);
    }

    @Test
    public void printTotalAges()
    {
        List<Person> people = createPeople();

        int totalAges = people.stream().map( Person::getAge)
        //        .reduce( 0 , (total , age) -> total + age);
        //        .reduce( 0 , (total , age) -> Integer.sum(total , age));
                .reduce( 0 , Integer::sum);
        System.out.println(totalAges);
    }
}
