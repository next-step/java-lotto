import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	private static final String PATTERN = "//(.)\n(.*)";
	private static final String DEFAULT_DELIMITER = ",|:";

	public static SeparatedText findSeparator(final String text){
		if(isEmpty(text)) {
			return null;
		}
		Matcher m = Pattern.compile(PATTERN).matcher(text);
		if (false == m.find()) {
			return new SeparatedText(DEFAULT_DELIMITER, text);
		}
		String delimiter = m.group(1);
		String texts= m.group(2);
		return new SeparatedText(addDelimiter(delimiter), texts);
	}

	private static String addDelimiter(final String delimiter){
		return new StringBuilder(DEFAULT_DELIMITER)
			.append("|")
			.append(delimiter)
			.toString();
	}

	public static String[] split(String delimiter, String text) {
		if(isEmpty(delimiter)
		   || isEmpty(text)){
			return null;
		}
		return text.split(delimiter);
	}

	private static boolean isEmpty(final String text){
		if(null == text
		   || text.isEmpty()){
			return true;
		}
		return false;
	}

	public static int sum(String[] texts) {
		return Arrays.stream(texts)
			  		.mapToInt(Integer::parseInt)
					.filter(StringAddCalculator::isNotNegative)
					.reduce(0, Integer::sum);
	}

	private static boolean isNotNegative(final int value){
		if(value < 0) {
			throw new RuntimeException("");
		}
		return true;
	}


	public static int splitAndSum(final String text){
		SeparatedText separatedText = findSeparator(text);
		if(null == separatedText){
			return 0;
		}
		String[] texts = split(separatedText.getDelimiter(), separatedText.getTexts());
		if(null == texts){
			return 0;
		}
		return sum(texts);
	}
}
