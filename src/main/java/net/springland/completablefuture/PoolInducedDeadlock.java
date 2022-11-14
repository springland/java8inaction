package net.springland.completablefuture;

import lombok.extern.java.Log;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

@Log
public class PoolInducedDeadlock {


    @Test
    public void sum() throws Exception
    {
        // do a divide concure calculation
        ExecutorService executorService = Executors.newCachedThreadPool();
        int[] nums = new int[] { 1 , 2 ,3 ,4 , 5};


        int total;
        int want ;
        Callable<Integer>  task;

        task = CalculateTaskUtil.createCalcualteTask(executorService , nums , 0 , nums.length-1 , 10);

        total = executorService.submit(task).get();

        want = IntStream.of(nums).sum();

        assertEquals(total , want);


        task = CalculateTaskUtil.createCalcualteTask(executorService , nums , 0 , nums.length-1 , 2);

        total = executorService.submit(task).get();

        want = IntStream.of(nums).sum();

        assertEquals(total , want);

    }

    @Test
    public void deadLock() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        int[] nums = new int[] { 1 , 2 ,3 ,4 , 5};


        int total;
        int want ;
        Callable<Integer>  task;

        task = CalculateTaskUtil.createCalcualteTask(executorService , nums , 0 , nums.length-1 , 2);

        total = executorService.submit(task).get();

        want = IntStream.of(nums).sum();

        assertEquals(total , want);

    }
}
