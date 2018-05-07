package com.example.maze.solver.algorithm;

import java.util.List;

import com.example.maze.solver.domain.Coordinate;
import com.example.maze.solver.domain.Maze;


public enum SearchAlgorithmStrategy implements SearchAlgorithm {

    BFS_ALGORITHM(new BFSAlgorithm()),
    DFS_ALGORITHM(new DFSAlgorithm());

    private final SearchAlgorithm delegate;
    
    private SearchAlgorithmStrategy(SearchAlgorithm delegate) {
	this.delegate = delegate;
    }

    @Override
    public List<Coordinate> apply(Maze maze) {
	return delegate.apply(maze);
    }
}
