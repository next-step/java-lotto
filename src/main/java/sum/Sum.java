package sum;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sum {
	public static int sum(String sumParam) {
		if(sumParam == null){
			return 0;
		}

		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(sumParam);
		if (m.find()) {
			String customDelimiter = m.group(1);
			String[] tokens= m.group(2).split(customDelimiter);

			return new ValueList(tokens).sum();
		}

		ValueList values = new ValueList(sumParam.split("[,:]"));
		return values.sum();
	}
}
