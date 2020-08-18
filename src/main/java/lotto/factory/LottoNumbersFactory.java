package lotto.factory;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import lotto.LottoNumbers;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LottoNumbersFactory {

	private static final int LOTTO_BALL_COUNT = 6;
	private static Random random = new Random();

	public static LottoNumbers create() {
		List<Integer> lottoNumbers = createNumbers();

		return LottoNumbers.of(lottoNumbers);
	}

	private static List<Integer> createNumbers() {
		List<Integer> allLottoNumbers = LottoNumbers.getAllShuffled();

		return IntStream.range(0, LOTTO_BALL_COUNT)
						.mapToObj(order -> {
							int orderToGet = random.nextInt(allLottoNumbers.size());
							return allLottoNumbers.remove(orderToGet);
						})
						.collect(Collectors.toList());
	}
}
