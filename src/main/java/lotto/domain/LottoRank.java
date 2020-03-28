package lotto.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum LottoRank {
	FOURTH(3, 5000),
	THIRD(4, 50000),
	SECOND(5, 1500000),
	FIRST(6, 2000000000);

	private static Map<Integer, LottoRank> correctMap = Arrays.stream(values())
			.collect(Collectors.toMap(rank -> rank.correctNumbers, Function.identity()));

	private final int correctNumbers;
	private final int earningPrize;

	LottoRank(int correctNumbers, int earningPrize) {
		this.correctNumbers = correctNumbers;
		this.earningPrize = earningPrize;
	}

	public static LottoRank getFromCorrectNumbers(int correctNumbers) {
		return correctMap.get(correctNumbers);
	}

	public int getCorrectNumbers() {
		return correctNumbers;
	}

	public int getEarningPrize() {
		return earningPrize;
	}
}
