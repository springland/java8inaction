package net.springland.streamcollector;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMappingAndFlatMap {

    @Test
    public void flatMapExample()
    {
        List<List<Integer>> numberListOfList = List.of(
                List.of(1 , 2 , 3),
                List.of(4 , 5 , 6)
        ) ;

        System.out.println(numberListOfList);

        System.out.println(
                numberListOfList.stream()
                        .flatMap( l -> l.stream())
                        .map( t-> t*2)
                        .collect(Collectors.toList())

        );


        List<Integer>  numbers = List.of( 1, 2, 3);

        System.out.println(
                numbers.stream().flatMap( num -> List.of(Integer.valueOf(num-1) , Integer.valueOf(num+1)).stream())
                        .collect(Collectors.toList()));
    }

    @Test
    public void findUniqueCharactersFromName()
    {
        System.out.println(
            PeopleList.createPeople().stream()
                    .map(Person::getName)
                    .flatMap( name -> Stream.of(name.split("")))
                    .collect(Collectors.toSet()));

    }


    @Test
    public void findCharsByAge()
    {
        System.out.println(

          PeopleList.createPeople().stream()
                  .collect(
                          Collectors.groupingBy(
                                  Person::getAge,
                                  Collectors.flatMapping(
                                         person -> Stream.of(person.getName().split("")),
                                         Collectors.toSet()
                                  )
                          )
                  )

        );
    }

}
