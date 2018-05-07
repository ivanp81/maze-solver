package com.example.maze.solver.domain;

import java.util.List;

public class Maze {

    private String[][] maze;
    private boolean[][] visited;

    private Coordinate start;
    private Coordinate end;

    private List<Coordinate> path;

    public String[][] getMaze() {
	return maze;
    }

    public void setMaze(String[][] maze) {
	this.maze = maze;
    }

    public boolean[][] getVisited() {
	return visited;
    }

    public void setVisited(boolean[][] visited) {
	this.visited = visited;
    }

    public Coordinate getStart() {
	return start;
    }

    public void setStart(Coordinate start) {
	this.start = start;
    }

    public Coordinate getEnd() {
	return end;
    }

    public void setEnd(Coordinate end) {
	this.end = end;
    }

    public List<Coordinate> getPath() {
	return path;
    }

    public int getHeight() {
	return maze.length;
    }

    public int getWidth() {
	return maze[0].length;
    }

    public boolean isEnd(int x, int y) {

	return x == end.getX() && y == end.getY();
    }

    public boolean isStart(int x, int y) {
	return x == start.getX() && y == start.getY();
    }

    public boolean isVisited(int row, int col) {
	return visited[row][col];
    }

    public boolean isWall(int row, int col) {
	return maze[row][col] == MazeMarker.WALL.getValue();
    }

    public void setVisited(int row, int col, boolean value) {
	visited[row][col] = value;
    }

    public boolean isValidLocation(int row, int col) {
	if (row < 0 || row >= getHeight() || col < 0 || col >= getWidth()) {
	    return false;
	}
	return true;
    }
    
    public void setValueAt(String value, int row, int col) {
	maze[row][col] = value;
    }

    public void setAndTrackPath(List<Coordinate> path) {
	this.path = path;
	trackPath();
    }
    
    private void trackPath() {

	for (Coordinate coordinate : path) {

	    if (isStart(coordinate.getX(), coordinate.getY()) || isEnd(coordinate.getX(), coordinate.getY())) {
		continue;
	    }
	    maze[coordinate.getX()][coordinate.getY()] = MazeMarker.PATH.getValue();
	}
    }
}
