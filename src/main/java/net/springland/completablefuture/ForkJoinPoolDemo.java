package net.springland.completablefuture;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class ForkJoinPoolDemo {

    @Test
    public void sum() throws Exception
    {

        int[] nums = new int[] { 1 , 2 ,3 ,4 , 5};

        ExecutorService executorService = Executors.newWorkStealingPool(1);



        int total;
        int want ;
        Callable<Integer> task;

        task = CalculateTaskUtil.createCalcualteTask(executorService , nums , 0 , nums.length-1 , 2);

        total = executorService.submit(task).get();

        want = IntStream.of(nums).sum();

        assertEquals(total , want);

    }


    @Test
    public void sum2() {
        ForkJoinPool forkJoinPool = new ForkJoinPool(1);

        int[] nums = new int[] { 1 , 2 ,3 ,4 , 5};

        SumTask task = new SumTask(nums , 0 , nums.length-1 , 2);

        forkJoinPool.execute(task);
        assertEquals((int)task.join() , 15);
    }

}

class SumTask extends RecursiveTask<Integer> {

    private int[] nums ;
    private int beginIndex ;
    private int endIndex ;
    private int threshold ;

    SumTask(int nums[] , int beginIndex , int endIndex , int threshold)
    {
        this.nums = nums ;
        this.beginIndex = beginIndex ;
        this.endIndex = endIndex ;
        this.threshold = threshold ;

    }
    @Override
    protected Integer compute() {
        if( endIndex - beginIndex < threshold){
            return IntStream.of(Arrays.copyOfRange(nums , beginIndex , endIndex+1)).sum();
        }
        else{
            int middleIndex = beginIndex + (endIndex - beginIndex)/2;
            SumTask  task1 = new SumTask(nums , beginIndex , middleIndex , threshold);
            SumTask  task2 =  new SumTask(nums , middleIndex+1 , endIndex , threshold);
            return ForkJoinTask.invokeAll(List.of(task1 , task2)).stream().map(ForkJoinTask::join).reduce( 0 , (subtotal , result) -> subtotal + result);


        }
    }
}
