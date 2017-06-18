package net.springland.java8inaction.chapter2;

/**
 * Created by fl on 6/17/2017.
 */
public class AppleWeightOnlyFormatter implements AppleFormatter {
    @Override
    public String format(Apple apple) {
        return String.valueOf(apple.getWeight());
    }
}
