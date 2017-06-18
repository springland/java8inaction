package net.springland.java8inaction.chapter2;

/**
 * Created by fl on 6/17/2017.
 */
public class AppleHeavyWeightPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
