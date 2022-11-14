package net.springland.completablefuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class CalculateTaskUtil {

    public static  Callable<Integer> createCalcualteTask(ExecutorService executorService , int[] nums , int beginIndex , int endIndex , final int threshold)
    {


        return ( ) -> {
            if( endIndex - beginIndex+1 <= threshold) {


                int total =   IntStream.range(beginIndex , endIndex+1)
                        .map( index -> nums[index])
                        .sum();

                return total ;
            }
            else{
                int middleIndex = beginIndex + ( endIndex - beginIndex)/2 ;

                Callable<Integer>  left = createCalcualteTask(executorService , nums , beginIndex , middleIndex , threshold) ;
                Callable<Integer>  right = createCalcualteTask(executorService , nums , middleIndex+1  , endIndex , threshold);



                Future<Integer> leftResult = executorService.submit(left);
                Future<Integer> rightResult = executorService.submit(right);

                return leftResult.get() + rightResult.get();

            }

        };
    }

}
