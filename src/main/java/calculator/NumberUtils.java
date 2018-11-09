package calculator;

public class NumberUtils {

	public static Number[] parseNumbers(String[] splitedNumbers) {
		Number[] numbers = new Number[splitedNumbers.length];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = new Number(splitedNumbers[i]);
		}
		return numbers;
	}
}