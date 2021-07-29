package lotto.domain;

import static java.util.stream.Collectors.*;

import java.util.Collections;
import java.util.List;

public class LottoPrizes {

	private final List<LottoPrize> lottoPrizes;

	private LottoPrizes(List<LottoPrize> lottoPrizes) {
		this.lottoPrizes = lottoPrizes;
	}

	public static LottoPrizes from(List<LottoPrize> lottoPrizes) {
		return new LottoPrizes(lottoPrizes);
	}

	public int size() {
		return lottoPrizes.size();
	}

	public LottoPrizes countOf(LottoPrize lottoPrize) {
		List<LottoPrize> prizes = lottoPrizes.stream()
									.filter(prize -> prize.equals(lottoPrize))
									.collect(collectingAndThen(toList(), Collections::unmodifiableList));
		return LottoPrizes.from(prizes);
	}

	public int winningMoney() {
		return lottoPrizes.stream()
				.mapToInt(LottoPrize::prizeMoney)
				.sum();
	}
}
