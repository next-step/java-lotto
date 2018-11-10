package calculator;

public class StringCalculator {

	public static int add(String value) {
		StringNumber stringNumber = new StringNumber(value);

		// 문자열을 숫자로 변환
		Numbers numbers = new Numbers(stringNumber);

		// 숫자를 더한다.
		return numbers.addAll();
	}
}
