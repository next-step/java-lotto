package calculator;

class Delimiter {
	static final String DEFAULT_DELIMITER = "[,:]";

	private String value = DEFAULT_DELIMITER;

	Delimiter(String str) {
		if (isEmpty(str)) {
			return;
		}

		value = str;
	}

	private boolean isEmpty(String str) {
		return str == null || str.isEmpty();
	}

	String get() {
		return value;
	}

}
