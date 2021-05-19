package study;

public class StringAddCalculator {

	private StringAddCalculator() {
	}

	public static int splitAndSum(String str) {
		NumberPatternExtractor extractor = new NumberPatternExtractor(str);
		Delimiter delimiter = new Delimiter(extractor.getDelimiterText());
		String numberText = extractor.getNumberText();
		StringSplitter splitter = new StringSplitter(delimiter, numberText);

		return sum(parseNonNegativeIntegers(splitter.get()));
	}

	private static NonNegativeInteger[] parseNonNegativeIntegers(String[] strings) {
		NonNegativeInteger[] result = new NonNegativeInteger[strings.length];

		for (int i = 0; i < strings.length; i++) {
			result[i] = new NonNegativeInteger(strings[i]);
		}

		return result;
	}

	private static int sum(NonNegativeInteger[] integers) {
		int result = 0;

		for (NonNegativeInteger integer : integers) {
			result += integer.get();
		}

		return result;
	}

}
