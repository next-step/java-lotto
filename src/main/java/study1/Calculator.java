package study1;

import java.util.Arrays;

public class Calculator {
	public static int calculator(String numbers) {
		return Arrays.stream(Splitter.split(numbers)).mapToInt(Integer::parseInt).sum();
	}
}
