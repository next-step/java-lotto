package calculator;

public class StringUtils {

	private StringUtils() {

	}

	public static int toInt(String value) {
		validate(value);

		int intValue = Integer.parseInt(value);

		if (intValue < 0) {
			throw new IllegalArgumentException("양수만 입력이 가능합니다.");
		}

		return intValue;
	}

	private static void validate(String value) {
		if ("".equals(value)) {
			throw new IllegalArgumentException("문자열에 빈값을 입력 할 수 없습니다.");
		}

		System.out.println(value);
		if (!value.matches("-?\\d+")) {
			throw new IllegalArgumentException("숫자가 아닙니다.");
		}
	}
}
