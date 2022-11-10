package net.springland.streamcollector;

import org.junit.Test;

import java.util.stream.Collectors;

public class Joining {
    @Test
    public void testJoining()
    {
        // Create Comma Seperated names in upper case of people older than 30

        String uppercaseNames = PeopleList.createPeople().stream().filter( person -> person.getAge() > 30)
                .map(Person::getName).map(String::toUpperCase)
                .collect(Collectors.joining(","));
        System.out.println(uppercaseNames);
    }
}
