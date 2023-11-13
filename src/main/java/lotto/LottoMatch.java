package lotto;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoMatch {
	THREE(3),
	FOUR(4),
	FIVE(5),
	SIX(6);

	private static final Map<Integer, LottoMatch> stringToEnum =
			Stream.of(values()).collect(Collectors.toMap(LottoMatch::matchCount, e -> e));

	private final int matchCount;

	LottoMatch(int matchCount) {
		this.matchCount = matchCount;
	}

	public static LottoMatch fromInt(int matchCount) {
		return Optional.ofNullable(stringToEnum.get(matchCount))
				.orElseThrow(() -> new IllegalArgumentException("유효한 범위를 입력하세요"));
	}

	public int matchCount() {
		return this.matchCount;
	}
}
