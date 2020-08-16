package step1;

public class StringUtils {

	public static String[] split(String inputString) {
		DelimiterExtractor extractor = new DelimiterExtractor();
		String integers = extractor.separateDelimiterAndIntegers(inputString);
		return integers.split(extractor.getDelimiter());
	}

}
