package calculator;

public class StringCalculator {

	private static final char COMMA_DELIMITER = ',';

	public static int sumByDelimiter(String text) {
		if (isEmpty(text)) {
			return 0;
		}
		return 1;
	}

	private static boolean isEmpty(String text) {
		return text == null || text.isEmpty();
	}

	private static boolean hasDelimiter(String text, char delimiter) {
		return text.indexOf(delimiter) > -1;
	}
}
