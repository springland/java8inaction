package net.springland.streamcollector;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Reduce {
    /*

        lazy evaluation requires pure function , pure function = idempotent
        pure function does not change anything
        pure function does not depend on anything that may change

     */

    @Test
    public void nameToUppercase()
    {

        // get list of names , in upper case of thsoe
        // who are older than 30

        List<String> namesOfOlderThan30 = new ArrayList<>();

        // Do not do this , does not work. Breaks it should not depend on anything that may change
        // if change it to parallel stream , it may stop working
        List<Person> people = PeopleList.createPeople();
        people.stream().filter( p -> p.getAge()> 30).map(Person::getName).map( String::toUpperCase)
                .forEach(name -> namesOfOlderThan30.add(name));

        System.out.println(namesOfOlderThan30);


        // Collect is a reduce function

        List<String> namesOfOlderThan302 = people.stream().filter( person-> person.getAge() > 30).map( Person::getName)
                .map(String::toUpperCase).reduce(
                        new ArrayList<String>() ,
                        (names , name) -> {
                            names.add(name);
                            return names ;

                        },

                        (names1 , names2) -> {
                            names1.addAll(names2);
                            return names1 ;
                        }
                );

        System.out.println(namesOfOlderThan302);

        List<String> namesOfOlderThan303 = people.stream().filter( person-> person.getAge() > 30).map( Person::getName)
                .map(String::toUpperCase).collect(Collectors.toList());

        System.out.println(namesOfOlderThan303);
    }

    @Test
    public void testGetAllPersonsOlderThan30()
    {

        List<Person> people = PeopleList.createPeople();

        System.out.println(
                people.stream().filter( person-> person.getAge()> 30).collect(Collectors.toList())
        );
    }

    @Test
    public void testGetNameMap()
    {
        // create a map , name as key , value is list of person

        List<Person> people = PeopleList.createPeople();

        Map<String , List<Person>>  nameMap =
            people.stream().collect(groupingBy(Person::getName  ));

        System.out.println(nameMap);
    }

    @Test(expected =  UnsupportedOperationException.class)
    public void testToUnMOdifiable()
    {

        List<Person> people = PeopleList.createPeople();
        List<Integer> ages =people.stream().map(Person::getAge).collect(Collectors.toUnmodifiableList());
        ages.add(99);

    }






}
