package com.gojek.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author Somendra1.Raj
 *
 */
public class FileParser {
	
	/**
	 * this method will parse the input file from command line
	 * 
	 * @param filePath
	 */
	public static void parseInputFile(String filePath) {

		File inputFile = new File(filePath);
		try {
			BufferedReader br = new BufferedReader(new FileReader(inputFile));
			String line;
			try {
				while ((line = br.readLine()) != null) {
					parseTextInput(line.trim());
				}
			} catch (IOException ex) {
				System.out.println("Error in reading the input file.");
				ex.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found in the path specified.");
			e.printStackTrace();
		}

	}
	
	/**
	 * call the process request method, which will process the request 
	 * 
	 * @param params
	 */
	public static void parseTextInput(String params) {
		Cache.processRequest(params.split(" ")[0].toLowerCase(), params.split(" "));

	}

}
