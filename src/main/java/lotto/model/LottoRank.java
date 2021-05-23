package lotto.model;

import java.util.stream.Stream;

public enum LottoRank {
	FIRST(6, Money.ofWons(2_000_000_000), (countOfMatch, matchBonus) -> countOfMatch == 6),
	SECOND(5, Money.ofWons(30_000_000), (countOfMatch, matchBonus) -> countOfMatch == 5 && matchBonus),
	THIRD(5, Money.ofWons(1_500_000), (countOfMatch, matchBonus) -> countOfMatch == 5 && !matchBonus),
	FOURTH(4, Money.ofWons(50_000), (countOfMatch, matchBonus) -> countOfMatch == 4),
	FIFTH(3, Money.ofWons(5000), (countOfMatch, matchBonus) -> countOfMatch == 3),
	MISS(0, Money.ofWons(0), (countOfMatch, matchBonus) -> countOfMatch < 3);

	private final int countOfMatch;
	private final Money prize;
	private final LottoRankPolicy policy;

	LottoRank(int countOfMatch, Money prize, LottoRankPolicy policy) {
		this.countOfMatch = countOfMatch;
		this.prize = prize;
		this.policy = policy;
	}

	static LottoRank of(int countOfMatch, boolean matchBonus) {
		return Stream.of(LottoRank.values())
			.filter(rank -> rank.policy.test(countOfMatch, matchBonus))
			.findAny()
			.orElseThrow(IllegalArgumentException::new);
	}

	public int getCountOfMatch() {
		return countOfMatch;
	}

	public Money getPrize() {
		return prize;
	}

	Money multiplyPrize(int count) {
		return prize.times(count);
	}
}
