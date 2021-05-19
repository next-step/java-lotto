package study;

public class Delimiter {
	public static final String DEFAULT_DELIMITER = "[,:]";

	private final String value;

	public Delimiter(String str) {
		if (isBlank(str)) {
			str = DEFAULT_DELIMITER;
		}

		this.value = str;
	}

	private boolean isBlank(String str) {
		return str == null || str.isEmpty();
	}

	public String get() {
		return value;
	}
}
