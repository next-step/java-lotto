package lotto.modal;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.util.StringValid;

public class LottoNumber implements Comparable<LottoNumber> {

	//private static final Random randomGenerator = new Random();
	private static final int LOTTO_NUMBER_BOUND_MAX = 45;
	private static final int LOTTO_NUMBER_BOUND_MIN = 1;
	private static final List<LottoNumber> RANDOM_NUMBER_GENERATOR =
		IntStream.rangeClosed(LOTTO_NUMBER_BOUND_MIN, LOTTO_NUMBER_BOUND_MAX)
			.mapToObj(LottoNumber::generateNumber)
			.collect(Collectors.toList());

	private final int number;

	private LottoNumber(int lottoNumber) {
		this.number = lottoNumber;
	}

	public static LottoNumber generateNumber(int bonusNumber) {
		validateLottoNumber(bonusNumber);
		return new LottoNumber(bonusNumber);
	}

	public static LottoNumber generateNumber(String bonusNumber) {
		validateLottoNumber(bonusNumber);
		return generateNumber(Integer.parseInt(bonusNumber));
	}

	public static List<LottoNumber> generateRandomNumbers() {
		Collections.shuffle(RANDOM_NUMBER_GENERATOR);

		return RANDOM_NUMBER_GENERATOR.stream()
			.limit(6)
			.sorted()
			.collect(Collectors.toList());
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
	public String toString() {
		return Integer.toString(this.number);
	}

	@Override
	public int compareTo(LottoNumber lottoNumber) {
		return Integer.compare(this.number, lottoNumber.number);
	}
}
