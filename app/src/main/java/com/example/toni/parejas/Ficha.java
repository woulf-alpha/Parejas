package com.example.toni.parejas;

/**
 * Created by Toni on 30/09/2016.
 */

public class Ficha {
    private int x;
    private int y;
    private int n;

    public Ficha(int x, int y, int n) {
        this.x = x;
        this.y = y;
        this.n = n;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}
