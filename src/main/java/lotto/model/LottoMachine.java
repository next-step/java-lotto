package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

	private static final int LOTTO_END_SIZE = 6;
	private static final int LOTTO_START_SIZE = 0;
	private static final int LOTTO_START_NUMBER = 1;
	private static final int LOTTO_END_NUMBER = 46;

	private LottoMachine() {
	}

	public static List<Integer> createLottoNumber() {
		List<Integer> lottoBalls = IntStream.range(LOTTO_START_NUMBER, LOTTO_END_NUMBER)
			.boxed()
			.collect(Collectors.toList());
		Collections.shuffle(lottoBalls);
		return lottoBalls.subList(LOTTO_START_SIZE, LOTTO_END_SIZE);
	}
}
