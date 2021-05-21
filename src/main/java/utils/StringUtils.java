package utils;

import exception.StringAddCalculatorException;

import java.util.Arrays;

import static exception.StringAddCalculatorExceptionCode.NEGATIVE_TEXT;

public class StringUtils {

	public static String[] split(String delimiter, String text) {
		if(isEmpty(delimiter)
		   || isEmpty(text)){
			return null;
		}
		return text.split(delimiter);
	}

	public static boolean isEmpty(final String text){
		if(null == text
		   || text.isEmpty()){
			return true;
		}
		return false;
	}

	public static int sumWithOutNegative(String[] texts) {
		return Arrays.stream(texts)
					 .mapToInt(Integer::parseInt)
					 .filter(StringUtils::isNotNegative)
					 .reduce(0, Integer::sum);
	}

	private static boolean isNotNegative(final int value){
		if(value < 0) {
			throw StringAddCalculatorException.of(NEGATIVE_TEXT);
		}
		return true;
	}
}
