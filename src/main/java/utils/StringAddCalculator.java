package utils;

public class StringAddCalculator {

	private static final int DEFAULT_RETURN_NUMBER = 0;

	public static int splitAndSum(final String text){
		if (StringUtils.isEmpty(text)) {
			return DEFAULT_RETURN_NUMBER;
		}

		SeparatedText separatedText = SeparatedText.findSeparator(text);
		String[] texts = StringUtils.split(separatedText.getDelimiter(), separatedText.getTexts());
		if (StringUtils.isEmptyArray(texts)){
			return DEFAULT_RETURN_NUMBER;
		}
		return NumberUtils.sumWithOutNegative(texts);
	}
}
