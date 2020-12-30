package lotto.model;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.input.Money;
import lotto.domain.result.HasBonusNumber;
import lotto.domain.result.MatchCount;
import lotto.domain.result.MatchResultPerLotto;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoPrizePolicy {
	FIFTH(new MatchCount(3), new Money(5_000), new BonusPolicy(false)),
	FOURTH(new MatchCount(4), new Money(50_000), new BonusPolicy(false)),
	THIRD(new MatchCount(5), new Money(1_500_000), new BonusPolicy(false)),
	SECOND(new MatchCount(5), new Money(30_000_000), new BonusPolicy(true)),
	FIRST(new MatchCount(6), new Money(2_000_000_000), new BonusPolicy(false));

	private MatchCount matchCount;

	private Money prizeMoney;

	private BonusPolicy bonusPolicy;

	LottoPrizePolicy(MatchCount matchCount, Money prizeMoney, BonusPolicy bonusPolicy) {
		this.matchCount = matchCount;
		this.prizeMoney = prizeMoney;
		this.bonusPolicy = bonusPolicy;
	}

	public MatchCount getMatchCount() {
		return matchCount;
	}

	public Money getPrizeMoney() {
		return prizeMoney;
	}

	public BonusPolicy getBonusPolicy() {
		return bonusPolicy;
	}

	public static Money getPrizeMoney(MatchResultPerLotto matchResultPerLotto, Money totalPrizeMoney) {
		for (LottoPrizePolicy policy : LottoPrizePolicy.values()) {
			Money prizeMoney = getPrizeMoneypolicy(policy, matchResultPerLotto.getMatchCount(), matchResultPerLotto.isHasBonusNumber());
			totalPrizeMoney.add(prizeMoney);
		}
		return totalPrizeMoney;
	}

	private static Money getPrizeMoneypolicy(LottoPrizePolicy policy, MatchCount inputMatchCount, HasBonusNumber hasBonusNumber) {
		if (policy.getMatchCount().getMatchCount() == inputMatchCount.getMatchCount() && policy.getBonusPolicy().isBonusPolicy() == hasBonusNumber.isHasBonusNumber()) {
			return new Money(policy.getPrizeMoney().getMoney());
		}
		return new Money(0);
	}

	public static MatchCount getMinMatchCount() {
		MatchCount minMatchPolicy = Stream.of(LottoPrizePolicy.values())
				.map(m -> m.getMatchCount())
				.collect(Collectors.toList()).stream()
				.min(Comparator.comparing(MatchCount::getMatchCount))
				.orElse(FIFTH.getMatchCount());

		return minMatchPolicy;
	}

	public static HasBonusNumber isMatchBonusNumber(Lotto lotto, LottoNumber bonusNumber) {
		return lotto.isMatchBonusNumber(bonusNumber);
	}
}



