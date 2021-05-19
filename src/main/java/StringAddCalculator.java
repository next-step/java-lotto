import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
	public static int splitAndSum(String inputText) {
		if (inputText == null || inputText.isEmpty()) {
			return 0;
		}

		return Arrays.stream(getStringTokens(inputText))
				.map(Integer::parseInt)
				.reduce(0, Integer::sum);
	}

	private static String[] getStringTokens(String text) {
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
		if (m.find()) {
			String customDelimiter = m.group(1);
			return m.group(2).split(customDelimiter);
		}

		return text.split("[,:]");
	}
}
