package study.step2.domain.value;

public class Number {
	private int number;

	private Number(int number) {
		this.number = number;
	}

	public static Number generate(String text) {
		int parsedInt = parse(text);
		isValid(parsedInt);
		return new Number(parsedInt);
	}

	private static boolean isValid(int parsedInt) {
		return isValidNotNegative(parsedInt);
	}

	private static boolean isValidNotNegative(int parsedInt) {
		if (-1 < parsedInt) {
			return true;
		}
		throw new RuntimeException("입력된 값 중 음수가 포함되어 있습니다. : " + parsedInt);
	}

	private static int parse(String text) {
		if (isNullOrEmpty(text)) {
			return 0;
		}
		return Integer.parseInt(text);
	}

	private static boolean isNullOrEmpty(String text) {
		return text == null || text.trim().isEmpty();
	}

	public int getNumber() {
		return this.number;
	}
}
