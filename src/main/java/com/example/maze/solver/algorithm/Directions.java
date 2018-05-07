package com.example.maze.solver.algorithm;

public enum Directions {

    NORTH(new int [] { 0, -1 }), 
    EST(new int [] { 1, 0 }), 
    SOUTH(new int [] { 0, 1 }), 
    WEST(new int [] { -1, 0 });

    private int [] value;

    private Directions(int [] value) {
	this.value = value;
    }

    public int [] getValue() {
	return value;
    }
}
