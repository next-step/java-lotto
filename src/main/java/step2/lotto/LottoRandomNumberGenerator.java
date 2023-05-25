package step2.lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import step2.lotto.domain.LottoNumber;

public class LottoRandomNumberGenerator implements LottoNumberGenerator {
	public static final int LOTTO_NUMBER_MIN = 1;
	public static final int LOTTO_NUMBER_MAX = 45;

	public static final int LOTTO_NUMBER_LENGTH = 6;

	public static LottoRandomNumberGenerator create() {
		return new LottoRandomNumberGenerator();
	}

	private LottoNumber generateRandomNumber() {
		int randomNumber = (int) (Math.random() * LOTTO_NUMBER_MAX) + LOTTO_NUMBER_MIN;

		return LottoNumber.from(randomNumber);
	}

	@Override
	public List<LottoNumber> generate() {
		return Stream.generate(this::generateRandomNumber)
			.limit(LOTTO_NUMBER_LENGTH)
			.collect(Collectors.toList());
	}
}
