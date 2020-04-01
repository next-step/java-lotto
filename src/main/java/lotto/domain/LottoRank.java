package lotto.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum LottoRank {
	FIFTH(3, 5_000, false),
	FOURTH(4, 50_000, false),
	THIRD(5, 1_500_000, false),
	SECOND(5, 30_000_000, true),
	FIRST(6, 2_000_000_000, false);

	private static final Map<Integer, LottoRank> notBonusMap = Arrays.stream(values())
			.filter(rank -> !rank.hasBonus)
			.collect(Collectors.toMap(LottoRank::getCorrectNumbers, Function.identity()));

	private static final Map<Integer, LottoRank> bonusMap = Arrays.stream(values())
			.filter(LottoRank::hasBonus)
			.collect(Collectors.toMap(LottoRank::getCorrectNumbers, Function.identity()));

	private final int correctNumbers;
	private final int earningMoney;
	private final boolean hasBonus;

	LottoRank(int correctNumbers, int earningMoney, boolean hasBonus) {
		this.correctNumbers = correctNumbers;
		this.earningMoney = earningMoney;
		this.hasBonus = hasBonus;
	}

	public int getCorrectNumbers() {
		return correctNumbers;
	}

	public int getWinningMoney() {
		return earningMoney;
	}

	public boolean hasBonus() {
		return hasBonus;
	}

	public static LottoRank getFromCorrectNumbers(int correctNumbers, boolean matchBonus) {
		if (matchBonus) {
			return bonusMap.getOrDefault(correctNumbers, notBonusMap.get(correctNumbers));
		}
		return notBonusMap.get(correctNumbers);
	}
}
