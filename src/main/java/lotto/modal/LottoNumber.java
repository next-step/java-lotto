package lotto.modal;

public class LottoNumber {

	public static final int LOTTO_NUMBER_BOUND_MAX = 45;
	public static final int LOTTO_NUMBER_BOUND_MIN = 1;

	private final int number;

	public LottoNumber(int lottoNumber) {

		validationLottoNumber(lottoNumber);
		this.number = lottoNumber;
	}

	@Override
	public String toString() {
		return "LottoNumber{" +
			"number=" + number +
			'}';
	}

	private void validationLottoNumber(int lottoNumber) {

		if (lottoNumber < LOTTO_NUMBER_BOUND_MIN || lottoNumber > LOTTO_NUMBER_BOUND_MAX) {
			throw new IllegalArgumentException("Lotto 번호 범위 에러: 1 ~ 45 사이의 값을 입력해 주세요.");
		}
	}
}
