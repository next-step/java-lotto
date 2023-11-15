package stringCalculator;

public class StringCalculator {
	private final String string;

	public StringCalculator(String string) {
		this.string = string;
	}

	public Integer calculate() {
		// null 이나 빈 공백 문자 입력시 IllegalArgumentException 발생
		if (isEmpty(string)) {
			throw new IllegalArgumentException("NULL 또는 공백을 입력할 수 없습니다.");
		}

		String[] strArr= splitStr();
		int arrSize = strArr.length;

		int result = strToInt(strArr[0]);
		for (int idx = 1; idx < arrSize; idx += 2) {
			result = BasicOperations
				.match(strArr[idx])
				.calculate(
					result,
					strToInt(strArr[idx+1])
				);
		}
		return result;
	}

	private boolean isEmpty(String str) {
		return str == null || str.isEmpty();
	}

	private String[] splitStr() {
		return string.split(" ");
	}

	private Integer strToInt(String str) {
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			throw new NumberFormatException("해당 문자열을 숫자로 변환할 수 없습니다.");
		}

	}
}
