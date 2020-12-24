package lotto.modal;

import java.util.Objects;
import java.util.Random;

import lotto.util.StringValid;

public class LottoNumber {

	private static final Random randomGenerator = new Random();
	private static final int LOTTO_NUMBER_BOUND_MAX = 45;
	private static final int LOTTO_NUMBER_BOUND_MIN = 1;

	private final int number;

	private LottoNumber(int lottoNumber) {
		this.number = lottoNumber;
	}

	public static int generateRandomLottoNumber() {
		return randomGenerator.nextInt(LottoNumber.LOTTO_NUMBER_BOUND_MAX) + LottoNumber.LOTTO_NUMBER_BOUND_MIN;
	}

	public static LottoNumber generateNumber(int bonusNumber) {
		validateLottoNumber(bonusNumber);
		return new LottoNumber(bonusNumber);
	}

	public static LottoNumber generateNumber(String bonusNumber) {
		validateLottoNumber(bonusNumber);
		return generateNumber(Integer.parseInt(bonusNumber));
	}

	private static void validateLottoNumber(int lottoNumber) {
		if (lottoNumber < LOTTO_NUMBER_BOUND_MIN || lottoNumber > LOTTO_NUMBER_BOUND_MAX) {
			throw new IllegalArgumentException("Lotto 번호 범위 에러: 1 ~ 45 사이의 값을 입력해 주세요.");
		}
	}

	private static void validateLottoNumber(String lottoNumber) {
		if (StringValid.isNoNNumber(lottoNumber)) {
			throw new IllegalArgumentException("Lotto 번호 범위 에러: 숫자를 입력해 주세요.");
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoNumber that = (LottoNumber)o;
		return number == that.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	@Override
	public String toString() {
		return Integer.toString(this.number);
	}
}
