package com.codenjoy.dojo.snakebattle.model;

public class PointX {

    private int x;
    private int y;
    private int priority;

    public PointX(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public PointX setX(int x) {
        this.x = x;
        return this;
    }

    public int getY() {
        return y;
    }

    public PointX setY(int y) {
        this.y = y;
        return this;
    }

    public int getPriority() {
        return priority;
    }

    public PointX setPriority(int priority) {
        this.priority = priority;
        return this;
    }

    @Override
    public String toString() {
        return "PointX{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

}
