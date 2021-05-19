package study;

public class Delimiter {
	public static final String DEFAULT_DELIMITER = "[,:]";

	private final String value;

	public Delimiter(String str) {
		this.value = convertBlankToDefault(str);
	}

	private String convertBlankToDefault(String str) {
		if (isBlank(str)) {
			return DEFAULT_DELIMITER;
		}

		return str;
	}

	private boolean isBlank(String str) {
		return str == null || str.isEmpty();
	}

	public String get() {
		return value;
	}
}
