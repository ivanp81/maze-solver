package com.example.maze.solver.domain.builder;

import java.io.File;
import java.io.FileNotFoundException;

import com.example.maze.solver.domain.Coordinate;
import com.example.maze.solver.domain.Maze;
import com.example.maze.solver.domain.MazeMarker;
import com.example.maze.solver.util.MazeUtil;

public class MazeBuilder {

    private static final String WALL = "1";
    
    private String[] inputLines;
    private Maze maze;

    public MazeBuilder(File file) throws FileNotFoundException {
	inputLines = MazeUtil.fileAsLines(file);
    }

    public Maze build() {
	maze = new Maze();
	initializeMazeWithDimensions();
	initializeStart();
	initializeEnd();
	initializeMazeWithMarker();
	return maze;
    }

    private MazeBuilder initializeMazeWithDimensions() {

	String[] line1Values = MazeUtil.getLineValues(inputLines, 0);

	int width = MazeUtil.getIntFromLineValues(line1Values, 0);
	int height = MazeUtil.getIntFromLineValues(line1Values, 1);

	String[][] mazeData = new String[height][width];
	maze.setMaze(mazeData);
	
	boolean[][] visited = new boolean[height][width];
	maze.setVisited(visited);
	
	return this;
    }

    private void initializeStart() {
	Coordinate start = coordinateFromLine(1);
	maze.setStart(start);
    }

    private void initializeEnd() {
	Coordinate end = coordinateFromLine(2);
	maze.setEnd(end);
    }

    private Coordinate coordinateFromLine(int lineNumber) {

	String[] lineValues = MazeUtil.getLineValues(inputLines, lineNumber);
	Coordinate coordinate = new CoordinateBuilder(lineValues).build();
	return coordinate;
    }

    private void initializeMazeWithMarker() {

	for (int row = 0; row < maze.getMaze().length; row++) {

	    for (int col = 0; col < maze.getMaze()[0].length; col++) {

		if (maze.isStart(row, col))
		    maze.setValueAt(MazeMarker.START.getValue(), row, col);
		else if (maze.isEnd(row, col))
		    maze.setValueAt(MazeMarker.END.getValue(), row, col);
		else if (valueFromLineIsWall(row, col))
		    maze.setValueAt(MazeMarker.WALL.getValue(), row, col);
		else
		    maze.setValueAt(MazeMarker.PASSAGE.getValue(), row, col);
	    }
	}
    }

    private boolean valueFromLineIsWall(int row, int col) {
	String mazeLines = inputLines[row + 3];
	return mazeLines.split(" ")[col].equals(WALL);
    }
}
