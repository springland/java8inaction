package net.springland.streamcollector;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

//
//  GroupingBy and mapping -> (Function , Collector)
//  CollectingAndThen -> (Collector , Function)
//
public class GroupingBy {
    @Test
    public void groupingByMapping()
    {
        // group by name , value is list of age instead of person

        // this one use mapping
        Map<String , List<Integer>> ageByName ;

        ageByName = PeopleList.createPeople().stream()
                .collect( groupingBy( Person::getName , mapping( Person::getAge , toList())));

        System.out.println(ageByName);

    }

    @Test
    public void groupingByCounting()
    {
        // find the number of person by name

        Map<String , Long> countByName =
        PeopleList.createPeople().stream().collect(
                groupingBy( Person::getName , counting())
        );

        System.out.println(countByName);
    }

    @Test
    public void groupingByCollectingAndThen()
    {
            // same as findTheNumberOfPersonsByName
            // but want to get Integer instead of Long

        Map<String , Integer> countByName =
                PeopleList.createPeople().stream()
                        .collect(groupingBy( Person::getName ,
                                collectingAndThen(
                                        counting() ,
                                        Long::intValue  )));

        System.out.println(countByName);
    }
}
