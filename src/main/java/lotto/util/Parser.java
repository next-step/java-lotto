package lotto.util;

import exception.StringParsingToIntegerException;

public class Parser {

	public static int toInt(String value) {
		try {
			return Integer.parseInt(value);
		} catch (Exception e) {
			throw new StringParsingToIntegerException("정수로 변환할 수 없는 값입니다.");
		}
	}
}
