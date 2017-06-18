package net.springland.java8inaction.chapter2;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by fl on 6/17/2017.
 */
public class AppleFilter {


    public static Logger logger = Logger.getLogger(AppleFilter.class.getName());

    public static List<Apple> filterGreenApples(List<Apple> inventory)
    {
        List<Apple> result = new ArrayList<Apple>();
        for(Apple apple: inventory)
        {
            if(Color.GREEN.equals(apple.getColor()))
            {
                result.add(apple);
            }
        }
        return result ;
    }

    public static List<Apple> filterApplesByColor(List<Apple> inventory , Color color)
    {
        List<Apple> result = new ArrayList<Apple>();
        for(Apple apple: inventory)
        {
            if(color.equals(apple.getColor()))
            {
                result.add(apple);
            }
        }
        return result ;

    }

    public static List<Apple> filterApplesByWeight(List<Apple> inventory , int weight)
    {
        List<Apple> result = new ArrayList<Apple>();
        for(Apple apple : inventory)
        {
            if(apple.getWeight() > weight)
            {
                result.add(apple);
            }
        }
        return result ;
    }

    public static List<Apple> filterByPredicate(List<Apple> inventory , ApplePredicate p)
    {
        List<Apple> result = new ArrayList<Apple>();
        for(Apple apple : inventory)
        {
            if(p.test(apple))
            {
                result.add(apple);
            }
        }
        return result ;
    }

    public static void  printPrettyApples(List<Apple> inventory , AppleFormatter p)
    {
        for(Apple apple: inventory)
        {
           String msg = p.format(apple);
           logger.info(msg);
        }
    }
}
