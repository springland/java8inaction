package net.springland.java8inaction.chapter3;

import org.junit.Test;

/**
 * Created by fl on 6/18/2017.
 */
public class RunnableTest {

    @Test
    public void testRunnable()
    {
        Runnable r1 = () -> System.out.println("Runnable 1");
        Runnable r2 = new Runnable() {
            public void run()
            {
                System.out.println("Runnable 2");
            }
        };
        process(r1);
        process(r2);
        process(()-> System.out.println("This is awesome"));

    }

    public void process(Runnable r)
    {
        r.run();;
    }
}
