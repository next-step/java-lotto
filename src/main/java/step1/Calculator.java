package step1;

public class Calculator {
	private static final int EMPTY_VALUE = 0;

	public static int getIntegerSumOfStrings(String inputString) {
		if (StringUtils.isEmpty(inputString)) {
			return EMPTY_VALUE;
		}

		String[] strings = StringUtils.split(inputString);
		int sum = 0;
		for (String number : strings) {
			sum += Integer.parseInt(number);
		}
		return sum;
	}
}
