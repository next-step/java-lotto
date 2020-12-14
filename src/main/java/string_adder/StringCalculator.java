package string_adder;

class StringCalculator {

	private static final String TEXT_EMPTY = "";

	int sum(String text) {
		if (text == null) {
			return 0;
		}

		if (text.equals(TEXT_EMPTY)) {
			return 0;
		}

		return -1;
	}
}
