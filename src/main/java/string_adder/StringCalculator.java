package string_adder;

class StringCalculator {

	private static final String TEXT_EMPTY = "";

	int sum(String text) {
		if (isZeroReturnTarget(text)) {
			return 0;
		}

		return -1;
	}

	private boolean isZeroReturnTarget(String text) {
		return text == null || TEXT_EMPTY.equals(text);
	}
}
