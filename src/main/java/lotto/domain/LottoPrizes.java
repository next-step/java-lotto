package lotto.domain;

import static java.util.stream.Collectors.*;

import java.util.Collections;
import java.util.List;

public class LottoPrizes {

	private final List<LottoPrize> prizes;

	private LottoPrizes(List<LottoPrize> prizes) {
		this.prizes = prizes;
	}

	public static LottoPrizes from(List<LottoPrize> lottoPrizes) {
		return new LottoPrizes(Collections.unmodifiableList(lottoPrizes));
	}

	public LottoPrizes prizesOf(LottoPrize lottoPrize) {
		List<LottoPrize> prizesOfRank = prizes.stream()
											.filter(prize -> prize.equals(lottoPrize))
											.collect(collectingAndThen(toList(), Collections::unmodifiableList));
		return LottoPrizes.from(prizesOfRank);
	}

	public int winningMoney() {
		return prizes.stream()
				.mapToInt(LottoPrize::prizeMoney)
				.sum();
	}

	public double earningsRate(int money) {
		return (double) winningMoney() / money;
	}

	public int size() {
		return prizes.size();
	}
}
