package com.example.maze.solver.domain;

public class MazeInfo {

    public static final String MAZE_WARNING = "WARNING: Maze not initialized";
    private static final String PATH_NOT_FOUND = "PATH NOT FOUND";

    public void print(Maze maze) {

	    try {
		printPathNotFoundElseMaze(maze);
	    } catch (NullPointerException e) {
		printMazeWarning();
		throw e;
	    }
	    finally {
		printSpacing();
		printSpacing();
	    }
    }

    private void printMazeWarning() {
	System.out.println(MAZE_WARNING);
    }

    private void printPathNotFoundElseMaze(Maze maze) {
	if (maze.getPath().isEmpty())
	    printPathNotFound();
	else 
	    printMaze(maze);
    }

    private void printPathNotFound() {
	System.out.println(PATH_NOT_FOUND);
    }

    private void printMaze(Maze maze) {

	for (int row = 0; row < maze.getMaze().length; row++) {
	    for (int col = 0; col < maze.getMaze()[0].length; col++) {
		System.out.print(maze.getMaze()[row][col]);
	    }
	    printSpacing();
	}
    }

    private void printSpacing() {
	System.out.println("");
    }

}
