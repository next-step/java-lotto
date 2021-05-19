package lotto;

class LottoNumber {
	static final int MIN_NUMBER = 1;
	static final int MAX_NUMBER = 45;

	private final int number;

	LottoNumber(int inputNumber) {
		validateRange(inputNumber);
		this.number = inputNumber;
	}

	private void validateRange(int inputNumber) {
		if (inputNumber < MIN_NUMBER || inputNumber > MAX_NUMBER ) {
			throw new IllegalArgumentException("로또 번호 숫자 범위에 벗어납니다.");
		}
	}

	int getNumber() {
		return number;
	}
}
