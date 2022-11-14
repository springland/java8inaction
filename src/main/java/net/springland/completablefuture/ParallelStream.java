package net.springland.completablefuture;

import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class ParallelStream {

    @Test
    public void sum()
    {
        int[] nums = new int[]{ 1 ,2 ,3 ,4 ,5 , 6};
        int total = IntStream.of(nums).parallel().sum();
        assertEquals(total , 21);
    }

    @Test
    public  void sum2()
    {

        int[] nums = new int[]{ 1 ,2 ,3 ,4 ,5 , 6};
        int total = IntStream.of(nums).parallel().mapToObj(Integer::valueOf)
                .reduce(0, (subtotal, element) -> subtotal + element);

        assertEquals(total , 21);

        total = IntStream.of(nums)
                .mapToObj(Integer::valueOf)
                .collect(Collectors.reducing(0 , (subtotal, element) -> subtotal + element));
        assertEquals(total , 21);

    }
}
