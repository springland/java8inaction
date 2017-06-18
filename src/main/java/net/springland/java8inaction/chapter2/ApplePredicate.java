package net.springland.java8inaction.chapter2;

/**
 * Created by fl on 6/17/2017.
 */
@FunctionalInterface
public interface ApplePredicate {
    boolean test(Apple apple);
}
