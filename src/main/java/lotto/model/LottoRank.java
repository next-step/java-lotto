package lotto.model;

import static java.util.stream.Collectors.*;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Stream;

public enum LottoRank {
	SEVENTH(0, Money.ZERO_WONS),
	SIXTH(1, Money.ZERO_WONS),
	FIFTH(2, Money.ZERO_WONS),
	FOURTH(3, Money.ofWons(5000)),
	THIRD(4, Money.ofWons((50_000))),
	SECOND(5, Money.ofWons(1_500_000)),
	FIRST(6, Money.ofWons(2_000_000_000));

	private final int matchCount;
	private final Money prize;

	private static final Map<Integer, LottoRank> lottoRanksByMatchCount;
	static {
		LottoRank[] lottoRanks = LottoRank.values();
		lottoRanksByMatchCount = Stream.of(lottoRanks)
			.collect(collectingAndThen(toMap(rank -> rank.matchCount, rank -> rank), Collections::unmodifiableMap));
	}

	LottoRank(int matchCount, Money prize) {
		this.matchCount = matchCount;
		this.prize = prize;
	}

	static LottoRank of(int matchCount) {
		return lottoRanksByMatchCount.get(matchCount);
	}

	public int getMatchCount() {
		return matchCount;
	}

	public Money getPrize() {
		return prize;
	}
}
