package com.example.maze.solver.domain.builder;

import com.example.maze.solver.domain.Coordinate;

public class CoordinateBuilder {

    private Coordinate coordinate;
    private String[] lineValues;

    public CoordinateBuilder(String[] lineValues) {
	this.lineValues = lineValues;
    }

    public Coordinate build() {
	coordinate = new Coordinate(Integer.valueOf(lineValues[1]), Integer.valueOf((lineValues[0])));
	return coordinate;
    }
}
