package lotto.model;

import static java.util.stream.Collectors.*;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Stream;

public enum LottoRank {
	SEVENTH(0),
	SIXTH(1),
	FIFTH(2),
	FOUR(3),
	THIRD(4),
	SECOND(5),
	FIRST(6);

	private final int matchCount;
	private static final Map<Integer, LottoRank> lottoRanksByMatchCount;
	static {
		LottoRank[] lottoRanks = LottoRank.values();
		lottoRanksByMatchCount = Stream.of(lottoRanks)
			.collect(collectingAndThen(toMap(rank -> rank.matchCount, rank -> rank), Collections::unmodifiableMap));
	}

	LottoRank(int matchCount) {
		this.matchCount = matchCount;
	}

	static LottoRank of(int matchCount) {
		return lottoRanksByMatchCount.get(matchCount);
	}
}
