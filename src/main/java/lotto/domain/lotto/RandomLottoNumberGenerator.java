package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoNumberGenerator implements LottoNumbersGeneratePolicy {

	private static final int LOTTO_MIN_NUMBER = 1;
	private static final int LOTTO_MAX_NUMBER = 45;

	@SuppressWarnings("FieldCanBeLocal")
	private static int START_INDEX = 0;
	@SuppressWarnings("FieldCanBeLocal")
	private static int GENERATE_NUMBERS_COUNT = 6;

	private static List<Integer> NUMBER_BALLS = IntStream
												.range(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
												.boxed()
												.collect(Collectors.toList());

	@Override
	public List<Integer> generate() {
		Collections.shuffle(NUMBER_BALLS);
		return NUMBER_BALLS.subList(START_INDEX, GENERATE_NUMBERS_COUNT);
	}

}
