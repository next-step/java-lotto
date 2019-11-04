package step1;


import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
	private String delimiters = ",|:";

	public int add(String text) {
		if (text == null || text.isEmpty()) return 0;

		Matcher m = Pattern.compile("(//(.)\n)?(.+)").matcher(text);
		if (!m.matches()) return 0;
		if (m.group(2) != null && !m.group(2).isEmpty()) delimiters += "|" + m.group(2);
		return getSum(m.group(3).split(delimiters));
	}

	private int getSum(String[] tokens) {
		int sum = 0;
		for (String s : tokens) {
			sum += parseNumber(s);
		}

		return sum;
	}

	private int parseNumber(String s) {
		int n;
		try {
			n = Integer.parseInt(s);
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}

		if (n < 0) throw new IllegalArgumentException("음수는 사용 불가");
		return n;
	}

	public boolean hasDelimiter(String delimiter) {
		return Arrays.asList(delimiters.split("\\|")).contains(delimiter);
	}
}
