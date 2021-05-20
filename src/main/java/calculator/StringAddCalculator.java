package calculator;

public class StringAddCalculator {

	private static final int ZERO = 0;

	public int splitAndSum(String patternText) {
		if (patternText == null || patternText.isEmpty()) {
			return ZERO;
		}

		NonNegativeIntegers integers = getNonNegativeIntegers(patternText);

		return integers.sum();
	}

	private NonNegativeIntegers getNonNegativeIntegers(String patternText) {
		NumberPatternExtractor extractor = new NumberPatternExtractor(patternText);
		StringSplitter splitter = new StringSplitter(extractor.getDelimiterText());
		String numberText = extractor.getNumberText();

		return new NonNegativeIntegers(splitter.split(numberText));
	}

}
