package com.example.maze.solver.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.maze.solver.domain.Coordinate;
import com.example.maze.solver.domain.Maze;

//Depth-first search
public class DFSAlgorithm implements SearchAlgorithm {

    private static final int[][] DIRECTIONS = { Directions.SOUTH.getValue(), 
	    					Directions.EST.getValue(), 
	    					Directions.NORTH.getValue(), 
	    					Directions.WEST.getValue()};
    
    public List<Coordinate> apply(Maze maze) {
        List<Coordinate> path = new ArrayList<>();
        if (pathExists(maze, 
        	      maze.getStart().getX(),
        	      maze.getStart().getY(),
        	      path)) {
            
            return path;
        }
        return Collections.emptyList();
    }

    private boolean pathExists(Maze maze, int row, int col, List<Coordinate> path) {
        if (!maze.isValidLocation(row, col) || maze.isWall(row, col) || maze.isVisited(row, col)) {
            return false;
        }

        path.add(new Coordinate(row, col));
        maze.setVisited(row, col, true);

        if (maze.isEnd(row, col)) {
            return true;
        }

        for (int[] direction : DIRECTIONS) {
            Coordinate neighbor = getNeighbor(row, col, direction[0], direction[1]);
            if (pathExists(maze, neighbor.getX(), neighbor.getY(), path)) {
                return true;
            }
        }

        path.remove(path.size() - 1);
        return false;
    }

    private Coordinate getNeighbor(int row, int col, int i, int j) {
        return new Coordinate(row + i, col + j);
    }
}
