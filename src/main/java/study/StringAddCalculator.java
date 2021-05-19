package study;

public class StringAddCalculator {

	private final static String CUSTOM_CONTAIN = "//";
	private final static int ZERO = 0;

	private StringAddCalculator () {}

	public static int splitAndSum(String stringNumbers) {
		if (isNullOrEmpty(stringNumbers))
			return ZERO;
		StringAddSplitter stringAddSplitter = getSplitter(stringNumbers);
		stringAddSplitter.split();
		String[] tokens = stringAddSplitter.getTokens();
		return getSumByTokens(tokens);
	}

	private static boolean isNullOrEmpty(String stringNumbers) {
		return stringNumbers == null || stringNumbers.isEmpty();
	}

	private static int getSumByTokens(String[] tokens) {
		int sum = 0;
		for (String number : tokens) {
			sum += Integer.parseInt(number);
		}
		return sum;
	}

	private static StringAddSplitter getSplitter(String stringNumbers) {
		if (isCustomDelimiter(stringNumbers))
			return StringAddSplitter.createCustomSplitter(stringNumbers);
		return StringAddSplitter.createDefaultSplitter(stringNumbers);
	}

	private static boolean isCustomDelimiter(String stringNumbers) {
		return stringNumbers.contains(CUSTOM_CONTAIN);
	}

}
