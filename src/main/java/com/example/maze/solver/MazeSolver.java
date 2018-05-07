package com.example.maze.solver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import com.example.maze.solver.algorithm.SearchAlgorithm;
import com.example.maze.solver.algorithm.SearchAlgorithmStrategy;
import com.example.maze.solver.domain.Coordinate;
import com.example.maze.solver.domain.Maze;
import com.example.maze.solver.domain.MazeInfo;
import com.example.maze.solver.domain.builder.MazeBuilder;

public class MazeSolver {
    
    private SearchAlgorithm searchAlgorithm;
    private Maze maze;
    
    public static void main(String[] args) throws Exception {
        
	File input = new File("src/test/resources/maze/input.txt");
        
        MazeSolver mazeSolver = new MazeSolver();
        
        mazeSolver
            .findPath(input)
                .printSolution();
    }
    
    public MazeSolver() {
	this.searchAlgorithm = SearchAlgorithmStrategy.BFS_ALGORITHM;
    }
    
    public MazeSolver(SearchAlgorithm searchAlgorithm) {
	this.searchAlgorithm = searchAlgorithm;
    }

    public MazeSolver findPath(File input) throws FileNotFoundException {
	
	maze = new MazeBuilder(input).build();
    	List<Coordinate> foundPath = searchAlgorithm.apply(maze);
    	maze.setAndTrackPath(foundPath);    	
    	return this;
    }
    
    public void printSolution() {
	new MazeInfo().print(maze);
    }

    public boolean isPathFound() {
        return !maze.getPath().isEmpty();
    }
}