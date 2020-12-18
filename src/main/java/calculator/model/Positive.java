package calculator.model;

import java.util.Objects;

import calculator.util.StringValid;

public class Positive {

	public static final int POSITIVE_CHECK_SUM_ZERO = 0;
	private final int positiveNumber;

	public Positive(String inputUserVal) throws RuntimeException {

		validationPositive(inputUserVal);
		this.positiveNumber = getStringToNumber(inputUserVal);
	}

	public int getPositiveNumber() {

		return this.positiveNumber;
	}

	private int getStringToNumber(String inputUserVal) {

		return Integer.parseInt(inputUserVal);
	}

	private void validationPositive(String inputUserVal) {

		if (StringValid.isNoNNumber(inputUserVal)) {
			throw new RuntimeException("숫자를 입력하지 않으셨습니다.");
		}

		if (isNegativeNumber(inputUserVal)) {
			throw new RuntimeException("0보다 큰 수를 입력해 주세요.");
		}
	}

	private boolean isNegativeNumber(String inputUserVal) {

		return Integer.parseInt(inputUserVal) < POSITIVE_CHECK_SUM_ZERO;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Positive positive = (Positive)o;
		return positiveNumber == positive.positiveNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(positiveNumber);
	}
}
