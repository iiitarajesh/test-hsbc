package dev.hsbc.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;
import java.util.stream.Collectors;

public class ReverseContentUtils {
	public static void main(String[] args) throws IOException {
		String inputPath = "./src/dev/hsbc/test/input.txt";
		String outputPath = "./src/dev/hsbc/test/output.txt";
		reverseContent(inputPath, outputPath);
		System.out.println("Content reversed. check output.txt file to see  the output");
	}

	private static void reverseContent(String inputPath, String outputPath) {
		try {
			FileReader fr = new FileReader(inputPath);
			BufferedReader br = new BufferedReader(fr);
			String input = br.lines().collect(Collectors.joining());
			br.close();
			Stack<Character> sc = new Stack<>();
			input.chars().mapToObj(c -> Character.valueOf((char) c)).forEach(cr -> sc.push(cr));
			StringBuilder sb = new StringBuilder();
			while (!sc.isEmpty()) {
				sb.append(sc.pop());
			}
			FileWriter fw = new FileWriter(outputPath);
			fw.write(sb.toString());
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
