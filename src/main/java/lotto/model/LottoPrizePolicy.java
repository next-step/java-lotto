package lotto.model;

import lotto.domain.GeneratedLotto;
import lotto.domain.LottoMatchResult;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public enum LottoPrizePolicy {
	THREE_MATCH_PRIZE(3, 5_000, false),
	FOUR_MATCH_PRIZE(4, 50_000, false),
	FIVE_MATCH_PRIZE(5, 1_500_000, false),
	SECOND(5, 30_000_000, true),
	SIX_MATCH_PRIZE(6, 2_000_000_000, false);

	private int matchCount;

	private int prizeMoney;

	private boolean isBonus;

	LottoPrizePolicy(int matchCount, int prizeMoney, boolean isBonus) {
		this.matchCount = matchCount;
		this.prizeMoney = prizeMoney;
		this.isBonus = isBonus;
	}

	public int getMatchCount() {
		return matchCount;
	}

	public int getPrizeMoney() {
		return prizeMoney;
	}

	public static int getPrizeMoney(LottoMatchResult lottoMatchResult, int totalPrizeMoney) {
		for (LottoPrizePolicy policy : LottoPrizePolicy.values()) {
			totalPrizeMoney += getPrizeMoneypolicy(policy, lottoMatchResult.getMatchResult(),lottoMatchResult.isHasBonusNumber());
		}
		return totalPrizeMoney;
	}

	private static int getPrizeMoneypolicy(LottoPrizePolicy policy, int inputMatchCount, boolean hasBonusNumber) {
		if (policy.getMatchCount() == inputMatchCount && policy.isBonus == hasBonusNumber) {
			return policy.getPrizeMoney();
		}
		return 0;
	}

	public static int getMinMatchCount() {
		LottoPrizePolicy minMatchPolicy = Arrays.asList(LottoPrizePolicy.values())
				.stream()
				.min(Comparator.comparing(LottoPrizePolicy::getMatchCount))
				.orElse(THREE_MATCH_PRIZE);
		return minMatchPolicy.getMatchCount();
	}

	public static boolean checkBonusNumber(GeneratedLotto generatedLotto, int countOfMatch, int bonusNumber) {
		boolean isMatchBonus = isMatchBonusNumber(generatedLotto,bonusNumber);

		if(isMatchBonus && FIVE_MATCH_PRIZE.getMatchCount() == countOfMatch){

		}


		return false;
	}

	public static boolean isMatchBonusNumber(GeneratedLotto generatedLotto, int bonusNumber) {
		return generatedLotto.lottoNumbers.stream().collect(Collectors.toList()).contains(bonusNumber);
	}
}



