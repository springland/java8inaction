package net.springland.java8inaction.chapter2;


import com.google.common.base.MoreObjects;

import java.awt.*;

/**
 * Created by fl on 6/17/2017.
 */
public class Apple {




    protected Color color ;
    protected int weight ;

    public Apple()
    {

    }

    public Color getColor()
    {
        return this.color ;
    }

    public int  getWeight()
    {
        return this.weight ;
    }

    public Apple(Color color , int weight)
    {
        this.color = color ;
        this.weight = weight ;
    }

    @Override
    public String toString()
    {
        return MoreObjects.toStringHelper(this.getClass()).add("Color:" , this.color).add("Weight" , this.weight).toString();
    }

}
