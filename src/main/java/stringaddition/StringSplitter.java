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
		return isInt(s) < 0;
	}

	private int isInt(String s) {
		int parseInt = 0;
		try {
			parseInt = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			throw new SplitException("숫자가 아닌 문자를 포함하는 문자열은 계산할 수 없습니다.");
		}
		return parseInt;
	}

	private boolean isBlank(String text) {
		return text == null || text.trim().isEmpty();
	}

}
