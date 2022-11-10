package net.springland.streamcollector;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.*;

public class MaxByAndMinBy {


    @Test
    public void maxByAge() {
        List<Person> people = PeopleList.createPeople() ;

        Optional<Integer> maxAge = people.stream().map(Person::getAge).collect(maxBy( (age1 , age2) -> age1 - age2 ));
        System.out.println(maxAge);

    }


    @Test
    public void maxByPerson() {
        List<Person> people = PeopleList.createPeople() ;

        Optional<Person> maxAgePerson = people.stream().collect(maxBy( (person1 , person2) -> person1.getAge() - person2.getAge() ));
        System.out.println(maxAgePerson);
    }

    @Test
    public void maxByPersonGetNameOnly(){
        // use collectingAndThen to get the name
        // maxBy returns optional  , so there is a map in the last step
        List<Person> people = PeopleList.createPeople() ;

        String maxAgePersonName = people.stream()
                .collect(collectingAndThen(maxBy( Comparator.comparing(Person::getAge) )
                        , person -> person.map(Person::getName).orElse("")));

        System.out.println(maxAgePersonName);
    }
    @Test
    public void minByAge() {
        List<Person> people = PeopleList.createPeople() ;

        Optional<Integer> maxAge = people.stream().map(Person::getAge).collect(minBy( (age1 , age2) -> age1 - age2 ));
        System.out.println(maxAge);

    }

}
