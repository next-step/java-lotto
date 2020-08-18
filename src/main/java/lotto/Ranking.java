package lotto;

import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Ranking {

	FIRST(6, 2000000000),
	SECOND(5, 1500000),
	THIRD(4, 50000),
	FOURTH(3, 5000),
	FAILURE(2, 0);

	private final int sameCount;
	private final long prizeMoney;

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
