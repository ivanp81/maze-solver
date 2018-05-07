package com.example.maze.solver.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.example.maze.solver.domain.Coordinate;
import com.example.maze.solver.domain.Maze;

//Breadth-first search
public class BFSAlgorithm implements SearchAlgorithm {

    private static final int[][] DIRECTIONS = { Directions.SOUTH.getValue(), 
	    					Directions.EST.getValue(), 
	    					Directions.NORTH.getValue(), 
	    					Directions.WEST.getValue()};
    
    public List<Coordinate> apply(Maze maze) {

	LinkedList<Coordinate> nextToVisit = new LinkedList<>();
	Coordinate start = maze.getStart();
	nextToVisit.add(start);

	while (!nextToVisit.isEmpty()) {

	    Coordinate cur = nextToVisit.remove();

	    if (!maze.isValidLocation(cur.getX(), cur.getY()) || maze.isVisited(cur.getX(), cur.getY())) {
		continue;
	    }

	    if (maze.isWall(cur.getX(), cur.getY())) {
		maze.setVisited(cur.getX(), cur.getY(), true);
		continue;
	    }

	    if (maze.isEnd(cur.getX(), cur.getY())) {
		return backTrackPath(maze, cur);
	    }

	    for (int[] direction : DIRECTIONS) {
		Coordinate coordinate = new Coordinate(cur.getX() + direction[0], cur.getY() + direction[1], cur);
		nextToVisit.add(coordinate);
		maze.setVisited(cur.getX(), cur.getY(), true);
	    }
	}
	
	return Collections.emptyList();
    }

    private List<Coordinate> backTrackPath(Maze maze, Coordinate cur) {

	List<Coordinate> path = new ArrayList<>();
	Coordinate iter = cur;

	while (iter != null) {
	    path.add(iter);
	    iter = iter.getParent();
	}

        return path;
    }
}
