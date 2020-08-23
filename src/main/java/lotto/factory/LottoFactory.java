package lotto.factory;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import lotto.Lotto;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LottoFactory {

	private static final int LOTTO_BALL_COUNT = 6;
	private static final int TOTAL_COUNT_OF_LOTTO_BALL = 45;
	private static final List<Integer> LOTTO_BALLS = IntStream.range(0, TOTAL_COUNT_OF_LOTTO_BALL)
															  .mapToObj(order -> order + 1)
															  .collect(Collectors.toList());

	private static Random random = new Random();

	public static Lotto create() {
		List<Integer> lottoNumbers = createNumbers();

		return Lotto.of(lottoNumbers);
	}

	private static List<Integer> createNumbers() {
		List<Integer> allLottoNumbers = getAllShuffled();

		return IntStream.range(0, LOTTO_BALL_COUNT)
						.mapToObj(order -> {
							int orderToGet = random.nextInt(allLottoNumbers.size());
							return allLottoNumbers.remove(orderToGet);
						})
						.collect(Collectors.toList());
	}

	private static List<Integer> getAllShuffled() {
		List<Integer> copiedLottoBalls = LOTTO_BALLS.stream()
													.collect(Collectors.toList());
		Collections.shuffle(copiedLottoBalls);

		return copiedLottoBalls;
	}
}
