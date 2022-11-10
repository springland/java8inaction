package net.springland.streamcollector;

import org.junit.Test;

import java.util.Map;

import static java.util.stream.Collectors.*;

public class Filtering {

    @Test
    public void runExample(){

        //
        // Still count by name , but filtering out the ages less than 20
        //

        Map<String , Long> countByName =
                PeopleList.createPeople().stream().collect(
                        groupingBy( Person::getName , filtering(person -> person.getAge() >20 , counting()))
                );

        System.out.println(countByName);

    }
}
