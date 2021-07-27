package stringaddition;

public class StringSplitter {

	private static final String DELIMITER = ",|:";
	private static final String[] ZERO = {"0"};

	public String[] split(String text) {
		if (isBlank(text)) {
			return ZERO;
		}

		String[] split = text.split(DELIMITER);
		hasNegative(split);

		return split;
	}

	private void hasNegative(String[] split) {
		for (String s : split) {
			validationInt(s);
		}
	}

	private void validationInt(String s) {
		if (isNegative(s)) {
			throw new SplitException();
		}
	}

	private boolean isNegative(String s) {
		return Integer.parseInt(s) < 0;
	}

	private boolean isBlank(String text) {
		return text == null || text.trim().isEmpty();
	}

}
