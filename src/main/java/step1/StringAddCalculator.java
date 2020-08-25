package step1;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	public static int splitAndSum(String str) {
		String[] tokens = StringSplitter.split(str);
		Number result = new Number();

		for(String s : tokens){
			result = result.add(new Number(s));
		}

		return result.getNumber();
	}
}
