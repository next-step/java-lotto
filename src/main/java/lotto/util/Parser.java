package lotto.util;

import exception.StringParsingToNumberException;

public class Parser {

	public static int toInt(String value) {
		try {
			return Integer.parseInt(value);
		} catch (Exception e) {
			throw new StringParsingToNumberException("정수로 변환할 수 없는 값입니다. [value=" + value + "]");
		}
	}

	public static long toLong(String value) {
		try {
			return Long.parseLong(value);
		} catch (Exception e) {
			throw new StringParsingToNumberException("정수로 변환할 수 없는 값입니다.");
		}
	}
}
