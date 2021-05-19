package study;

public class StringAddCalculator {

	private StringAddCalculator() {
	}

	public static int splitAndSum(String str) {
		StringSplitter splitter = getStringSplitter(str);
		NonNegativeIntegers integers = new NonNegativeIntegers(splitter.get());

		return integers.sum();
	}

	private static StringSplitter getStringSplitter(String str) {
		NumberPatternExtractor extractor = new NumberPatternExtractor(str);
		Delimiter delimiter = new Delimiter(extractor.getDelimiterText());
		String numberText = extractor.getNumberText();

		return new StringSplitter(delimiter, numberText);
	}

}
