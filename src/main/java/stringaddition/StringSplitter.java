package stringaddition;

public class StringSplitter {

	private static final String DELIMITER = ",|:";
	private static final String[] ZERO = {"0"};

	public String[] split(String text) {
		if (isBlank(text)) {
			return ZERO;
		}
		return text.split(DELIMITER);
	}

	private boolean isBlank(String text) {
		return text == null || text.trim().isEmpty();
	}

}
