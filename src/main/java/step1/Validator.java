package step1;

public class Validator {

	private static final String SIGN_EXCEPTION_MESSAGE = "사칙연산 기호가 아닙니다";
	private static final String NUMBER_EXCEPTION_MESSAGE = "숫자만 계산할 수 있습니다";

	public static int validateNumber(String term) {
		try {
			return Integer.parseInt(term);
		} catch (Exception e) {
			throw new IllegalArgumentException(NUMBER_EXCEPTION_MESSAGE);
		}
	}

	public static String validateSign(String sign) {
		if (!sign.equals("+") &&
			!sign.equals("-") &&
			!sign.equals("*") &&
			!sign.equals("/")) {
			throw new IllegalArgumentException(SIGN_EXCEPTION_MESSAGE);
		}
		return sign;
	}
}
