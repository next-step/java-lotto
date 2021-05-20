import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeparatedText {
	private static final String PATTERN = "//(.)\n(.*)";
	private static final String DEFAULT_DELIMITER = ",|:";

	private String delimiter;
	private String texts;


	public SeparatedText(final String delimiter, final String texts){
		this.delimiter = delimiter;
		this.texts = texts;
	}

	public String getDelimiter(){
		return this.delimiter;
	}

	public String getTexts(){
		return this.texts;
	}

	public static SeparatedText findSeparator(final String text){
		if(StringUtils.isEmpty(text)) {
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
}
