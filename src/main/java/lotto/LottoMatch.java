package lotto;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoMatch {
	THREE(3, 5000),
	FOUR(4, 50000),
	FIVE(5, 1500000),
	SIX(6, 2000000000);

	private static final Map<Integer, LottoMatch> stringToEnum =
			Stream.of(values()).collect(Collectors.toMap(LottoMatch::matchCount, e -> e));

	private final int matchCount;

	private final long amount;

	LottoMatch(int matchCount, long amount) {
		this.matchCount = matchCount;
		this.amount = amount;
	}

	public static LottoMatch fromInt(int matchCount) {
		return Optional.ofNullable(stringToEnum.get(matchCount))
				.orElseThrow(() -> new IllegalArgumentException("유효한 범위를 입력하세요"));
	}

	public int matchCount() {
		return this.matchCount;
	}

	public long amount() {
		return this.amount;
	}
}
