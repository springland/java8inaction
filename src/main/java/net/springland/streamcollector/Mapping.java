package net.springland.streamcollector;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class Mapping {

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

}
