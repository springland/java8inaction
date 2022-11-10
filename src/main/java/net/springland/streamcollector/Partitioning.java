package net.springland.streamcollector;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.partitioningBy;

public class Partitioning {

    @Test
    public void testPartitioning()
    {
        // create two groups to group people by if age is even

        Map<Boolean , List<Person>> partionByIfAgeIsEven = PeopleList.createPeople().stream().collect(
                partitioningBy( person -> person.getAge() %2 == 0)
        );

        System.out.println(partionByIfAgeIsEven);

    }
}
