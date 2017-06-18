package net.springland.java8inaction.chapter2;

import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by fl on 6/17/2017.
 */
public class AppleFilterTest {

    public List<Apple>  getInventory()
    {
        List<Apple> inventory = new ArrayList<Apple>();
        Apple apple = new Apple(Color.RED , 100);
        inventory.add(apple);
        apple = new Apple(Color.GREEN , 120);
        inventory.add(apple);
        apple = new Apple(Color.GREEN , 160);
        inventory.add(apple);

        return inventory ;
    }

    @Test
    public void testFilterGreenApples()
    {
        List<Apple> inventory = getInventory();

        List<Apple> greenApples = AppleFilter.filterGreenApples(inventory);
        assertTrue(greenApples.size() > 0);
        for(Apple apple1: greenApples)
        {
            assertEquals(apple1.getColor() , Color.GREEN);

        }
    }

    @Test
    public void testFilterByColor()
    {
        List<Apple> inventory = getInventory();

        List<Apple> redApples = AppleFilter.filterApplesByColor(inventory , Color.RED);
        assertTrue(redApples.size() > 0);
        for(Apple apple1: redApples)
        {
            assertEquals(apple1.getColor() , Color.RED);

        }

        List<Apple> greenApples = AppleFilter.filterApplesByColor(inventory , Color.GREEN);
        assertTrue(greenApples.size() > 0);
        for(Apple apple1: greenApples)
        {
            assertEquals(apple1.getColor() , Color.GREEN
            );
        }

        List<Apple>  whiteApples = AppleFilter.filterApplesByColor( inventory , Color.WHITE);
        assertTrue(whiteApples.isEmpty());

    }

    @Test
    public void testFilterBYWeight()
    {
        List<Apple> inventory = getInventory();

        List<Apple> filtered = AppleFilter.filterApplesByWeight(inventory , 150);
        assertEquals(filtered.size() , 1);
        for(Apple apple1: filtered)
        {
            assertTrue(apple1.getWeight() > 150);

        }

    }

    @Test
    public void testPredicate()
    {
        List<Apple> inventory = getInventory();
        ApplePredicate p = new AppleGreenColorPredicate();
        List<Apple> filtered = AppleFilter.filterByPredicate(inventory , p);
        assertEquals(filtered.size() , 2);
        for(Apple apple1: filtered)
        {
            assertEquals(apple1.getColor() , Color.GREEN);

        }


        filtered = AppleFilter.filterByPredicate(inventory , (Apple apple)-> apple.getWeight() > 120);
        for(Apple apple1: filtered)
        {
            assertTrue(apple1.getWeight() >120);

        }

    }

    @Test
    public void testFilter()
    {
        List<Apple> inventory = getInventory();
        List<Apple> redApples = AppleFilter.filter(inventory , (Apple apple) -> Color.RED.equals(apple.getColor()));
        for(Apple apple1: redApples)
        {
            assertEquals(apple1.getColor() , Color.RED);

        }
    }
}
