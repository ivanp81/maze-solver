package com.example.maze.solver.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MazeUtil {

    public static String[] fileAsLines(File file) throws FileNotFoundException {
	String fileText = fileAsText(file);
	String[] fileTextAsLines = fileTextAsLines(fileText);
	return fileTextAsLines;
    }

    private static String fileAsText(File file) throws FileNotFoundException {
	String fileText = "";

	try (Scanner input = new Scanner(file)) {
	    while (input.hasNextLine()) {
		fileText += input.nextLine() + "\n";
	    }
	}
	return fileText;
    }

    private static String[] fileTextAsLines(String fileText) {
	return fileText.split("[\r]?\n");
    }

    public static String[] getLineValues(String[] lines, int lineNumber) {
	return lines[lineNumber].split(" ");
    }

    public static int getIntFromLineValues(String[] line, int valuePosition) {
	return Integer.valueOf(line[valuePosition]);
    }

}
