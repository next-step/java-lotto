package util;

public class Parser {

	public static int toInt(String value) {
		try {
			return Integer.parseInt(value);
		} catch (Exception e) {
			throw new RuntimeException("숫자로 변환할 수 없는 입력입니다. [value=" + value + "]");
		}
	}
}
