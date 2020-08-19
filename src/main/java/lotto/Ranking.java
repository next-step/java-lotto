package lotto;

import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Ranking {

	FIRST(6, 2_000_000_000, true),
	SECOND(5, 1_500_000, true),
	THIRD(4, 50_000, true),
	FOURTH(3, 5_000, true),
	FAILURE(2, 0, false);

	private final int sameCount;
	private final long prizeMoney;
	private final boolean view;

	public static Ranking getRakingOf(int sameCount) {
		if (FIRST.sameCount < sameCount) {
			throw new IllegalArgumentException("당첨 개수는 6개를 넘을 수 없습니다.");
		}
		if (FAILURE.sameCount >= sameCount) {
			return FAILURE;
		}

		return Stream.of(values())
					 .filter(ranking -> ranking.sameCount == sameCount)
					 .findFirst()
					 .get();
	}
}
