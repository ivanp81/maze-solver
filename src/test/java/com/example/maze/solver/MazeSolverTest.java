package com.example.maze.solver;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;

import com.example.maze.solver.algorithm.SearchAlgorithmStrategy;

public class MazeSolverTest {

    @Test
    public void givenInput_whenFindPath_thenFoundPath() throws FileNotFoundException {
	
	File input = new File("src/test/resources/maze/input.txt");
	
	MazeSolver mazeSolver = new MazeSolver();
	mazeSolver.findPath(input);
	
	assertTrue(mazeSolver.isPathFound());
	
	mazeSolver.printSolution();
    }
    
    @Test
    public void givenLargeInput_whenFindPath_thenFoundPath() throws FileNotFoundException {
	
	File largeInput = new File("src/test/resources/maze/large_input.txt");
	
	MazeSolver mazeSolver = new MazeSolver();
	mazeSolver.findPath(largeInput);
	
	assertTrue(mazeSolver.isPathFound());
	
	mazeSolver.printSolution();
    }
    
    @Test
    public void givenMediumInput_whenFindPath_thenFoundPath() throws FileNotFoundException {
	
	File mediumInput = new File("src/test/resources/maze/medium_input.txt");
	
	MazeSolver mazeSolver = new MazeSolver();
	mazeSolver.findPath(mediumInput);
	
	assertTrue(mazeSolver.isPathFound());
	
	mazeSolver.printSolution();
    }
        
    @Test
    public void givenSmall_whenFindPath_thenFoundPath() throws FileNotFoundException {
	
	File small = new File("src/test/resources/maze/small.txt");
	
	MazeSolver mazeSolver = new MazeSolver();
	mazeSolver.findPath(small);
	
	assertTrue(mazeSolver.isPathFound());
	
	mazeSolver.printSolution();
    }
    
    @Test
    public void givenSparseMedium_whenFindPath_thenFoundPath() throws FileNotFoundException {
	
	File sparseMedium = new File("src/test/resources/maze/sparse_medium.txt");
	
	MazeSolver mazeSolver = new MazeSolver();
	mazeSolver.findPath(sparseMedium);
	
	assertTrue(mazeSolver.isPathFound());
	
	mazeSolver.printSolution();
    }
    
    @Test
    public void givenInputNoSolution_whenFindPath_thenPathNotFound() throws FileNotFoundException {
	
	File inputNoSolution = new File("src/test/resources/maze/input_no_solution.txt");
	
	MazeSolver mazeSolver = new MazeSolver();	
	mazeSolver.findPath(inputNoSolution);
	
	assertFalse(mazeSolver.isPathFound());
	
	mazeSolver.printSolution();
    }
    
    @Test(expected=NullPointerException.class)
    public void givenNullMaze_whenIsPathFound_thenNullPointerException() {
	
	MazeSolver mazeSolver = new MazeSolver();	
	mazeSolver.isPathFound();
    }
    
    @Test(expected=NullPointerException.class)
    public void givenNullMaze_whenPrintSolution_thenNullPointerException() {
	
	MazeSolver mazeSolver = new MazeSolver();	
	mazeSolver.printSolution(); 
    }
    
    @Test
    public void givenMazeWithoutWall_whenPrintSolution_thenFoundPath() throws FileNotFoundException {
	
	File mazeWithoutWall = new File("src/test/resources/maze/without_wall.txt");
	
	MazeSolver mazeSolver = new MazeSolver();	
	mazeSolver.findPath(mazeWithoutWall);
	
	assertTrue(mazeSolver.isPathFound());
	
	mazeSolver.printSolution(); 
    }
    
    @Test
    public void givenSmall_whenFindPathWithDFS_thenFoundPath() throws FileNotFoundException {
	
	File small = new File("src/test/resources/maze/small.txt");
	
	MazeSolver mazeSolver = new MazeSolver(SearchAlgorithmStrategy.DFS_ALGORITHM);
	mazeSolver.findPath(small);
	
	assertTrue(mazeSolver.isPathFound());
	
	mazeSolver.printSolution();
    }
}