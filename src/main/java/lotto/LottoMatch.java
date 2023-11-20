package lotto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoMatch {
	ZERO(0, 0),
	ONE(1, 0),
	TWO(2, 0),
	THREE(3, 5000),
	FOUR(4, 50000),
	FIVE(5, 1500000),
	SIX(6, 2000000000);

	private static final Map<Integer, LottoMatch> INTEGER_TO_ENUM =
			Stream.of(values()).collect(Collectors.toMap(LottoMatch::matchCount, e -> e));

	private final int matchCount;

	private final long amount;

	LottoMatch(int matchCount, long amount) {
		this.matchCount = matchCount;
		this.amount = amount;
	}

	public static LottoMatch fromInt(int matchCount) {
		return INTEGER_TO_ENUM.get(matchCount);
	}

	public static int matchesCount(int matchCount, LottoMatchResult lottoMatchResult) {
		long matchedCount =
			lottoMatchResult.lottoMatches()
				.stream()
				.filter(lottoMatch -> lottoMatch.matchCount() == matchCount)
				.count();

		return (int) matchedCount;
	}

	public int matchCount() {
		return this.matchCount;
	}

	public long amount() {
		return this.amount;
	}
}
