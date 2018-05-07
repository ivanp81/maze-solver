package com.example.maze.solver.domain;

public enum MazeMarker {

    PASSAGE(" "), WALL("#"), START("S"), END("E"), PATH("X");

    private String value;

    private MazeMarker(String value) {
	this.value = value;
    }

    public String getValue() {
	return value;
    }
}
