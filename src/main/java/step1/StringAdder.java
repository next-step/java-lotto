package step1;

public class StringAdder {

	private static final int ZERO = 0;

	private StringAdder() {}

	public static int calculate(String input) {
		if(isNullOrEmpty(input)) {
			return ZERO;
		}
		DelimiterAndNumbers delimiterAndNumbers = new DelimiterAndNumbers(input);
		return delimiterAndNumbers.sum();
	}

	private static boolean isNullOrEmpty(String string) {
		return string == null || string.trim()
										.isEmpty();
	}
}
