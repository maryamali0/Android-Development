/*
 Maryam Ali
 IT-372
 PROJECT 4
 Due: May 28
*/

package it372.alim.project4_alimaryam;

public class Point {
    //declare private vars
    private int id;
    private Float x;
    private Float y;

    public Point(int id, Float x, Float y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }
    //create getters for vars

    public int getId( ) {
        return id;
    }

    public Float getX( ) {
        return x;
    }

    public Float getY( ) {
        return y;
    }

    //return their values in string format
    @Override
    public String toString( ) {
        return String.format("%d,%d,%d", id, x, y);
    }
}

