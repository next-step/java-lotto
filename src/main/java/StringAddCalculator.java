public class StringAddCalculator {

	private static final int DEFAULT_RETURN_NUMBER = 0;

	public static int splitAndSum(final String text){
		SeparatedText separatedText = SeparatedText.findSeparator(text);
		if(null == separatedText){
			return DEFAULT_RETURN_NUMBER;
		}
		String[] texts = StringUtils.split(separatedText.getDelimiter(), separatedText.getTexts());
		if(null == texts){
			return DEFAULT_RETURN_NUMBER;
		}
		return StringUtils.sumWithOutNegative(texts);
	}
}
