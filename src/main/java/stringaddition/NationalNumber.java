package stringaddition;

public class NationalNumber {

	private static final int ZERO = 0;

	public void isValid(String s) {
		validateText(s);
		if (isNegative(s)) {
			throw new NationalNumberException();
		}
	}

	private boolean isNegative(String s) {
		return Integer.parseInt(s) < ZERO;
	}

	private void validateText(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			throw new NationalNumberException("숫자가 아닌 문자를 포함하는 문자열은 계산할 수 없습니다.");
		}
	}

}
