import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	private static final String PATTERN = "//(.)\n(.*)";

	public static SperatedText findSeperator(final String text){
		if(isEmpty(text)) {
			return null;
		}
		Matcher m = Pattern.compile(PATTERN).matcher(text);
		if (false == m.find()) {
			return null;
		}
		String delimiter = m.group(1);
		String texts= m.group(2);
		return new SperatedText(delimiter, texts);
	}

	private static boolean isEmpty(final String text){
		if(null == text
			|| text.isEmpty()){
			return true;
		}
		return false;
	}
}
