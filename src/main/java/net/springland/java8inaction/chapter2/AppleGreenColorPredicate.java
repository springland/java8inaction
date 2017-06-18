package net.springland.java8inaction.chapter2;

import java.awt.*;

/**
 * Created by fl on 6/17/2017.
 */
public class AppleGreenColorPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return Color.GREEN.equals(apple.getColor());
    }
}
