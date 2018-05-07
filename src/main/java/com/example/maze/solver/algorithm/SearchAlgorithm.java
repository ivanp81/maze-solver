package com.example.maze.solver.algorithm;

import java.util.List;

import com.example.maze.solver.domain.Coordinate;
import com.example.maze.solver.domain.Maze;


public interface SearchAlgorithm {

    public List<Coordinate> apply(Maze maze);
}
