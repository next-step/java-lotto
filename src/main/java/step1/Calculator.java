package step1;

public class Calculator {

	public static int getIntegerSumOfStrings(String[] strings) {
		int sum = 0;
		for (String number : strings) {
			sum += Integer.parseInt(number);
		}
		return sum;
	}
}
