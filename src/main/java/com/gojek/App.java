package com.gojek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.gojek.common.FileParser;

public class App {

	public static void main(String args[]) {

		switch (args.length) {
		case 0:
			System.out.println("Please enter 'exit' to close the app");
			System.out.println("Waiting for input...");
			for (;;) {
				try {
					BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
					String inputString = bufferRead.readLine();
					if (inputString.equalsIgnoreCase("exit")) {
						System.out.println("Program closed!");
						break;
					} else if ((inputString == null) || (inputString.isEmpty())) {

					} else {
						FileParser.parseTextInput(inputString.trim());
					}
				} catch (IOException e) {
					System.out.println("Error in reading the input from console.");
					e.printStackTrace();
				}
			}
			break;

		case 1:
			FileParser.parseInputFile(args[0]);
			break;
		default:
			String filePath = "D:/workspace/go-jek-parking-lot/input.txt";
			FileParser.parseInputFile(filePath);
		}
	}

}
