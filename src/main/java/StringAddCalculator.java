public class StringAddCalculator {

	public static int splitAndSum(final String text){
		SeparatedText separatedText = SeparatedText.findSeparator(text);
		if(null == separatedText){
			return 0;
		}
		String[] texts = StringUtils.split(separatedText.getDelimiter(), separatedText.getTexts());
		if(null == texts){
			return 0;
		}
		return StringUtils.sumWithOutNegative(texts);
	}
}
