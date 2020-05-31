package study1;

import java.util.Arrays;

public class Calculator {
	public static int calculator(String[] numbers) {
		return Arrays.stream(numbers).mapToInt(Integer::parseInt).sum();
	}
}
