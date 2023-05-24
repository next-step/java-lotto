package step2.lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoRandomNumberGenerator implements LottoNumberGenerator {
	public static final int LOTTO_NUMBER_MIN = 1;
	public static final int LOTTO_NUMBER_MAX = 45;

	public static final int LOTTO_NUMBER_LENGTH = 6;

	public static LottoRandomNumberGenerator create() {
		return new LottoRandomNumberGenerator();
	}

	private int generateRandomNumber() {
		return (int) (Math.random() * LOTTO_NUMBER_MAX) + LOTTO_NUMBER_MIN;
	}

	@Override
	public List<Integer> generate() {
		return IntStream.range(0, LOTTO_NUMBER_LENGTH)
			.mapToObj(i -> generateRandomNumber())
			.collect(Collectors.toList());
	}
}
