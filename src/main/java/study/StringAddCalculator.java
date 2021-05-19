package study;

public class StringAddCalculator {

	private StringAddCalculator() {
	}

	public static int splitAndSum(String str) {
		NumberPatternExtractor extractor = new NumberPatternExtractor(str);
		Delimiter delimiter = new Delimiter(extractor.getDelimiterText());
		String numberText = extractor.getNumberText();
		StringSplitter splitter = new StringSplitter(delimiter, numberText);
		NonNegativeIntegers integers = new NonNegativeIntegers(splitter.get());

		return integers.sum();
	}

}
