package lotto;

import java.util.function.BiPredicate;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Ranking {

	FIRST(6, 2_000_000_000, Ranking::equalsCount),
	SECOND(5, 30_000_000, Ranking::equalsSecondRanking),
	THIRD(5, 1_500_000, Ranking::equalsThirdRanking),
	FOURTH(4, 50_000, Ranking::equalsCount),
	FIFTH(3, 5_000, Ranking::equalsCount),
	FAILURE(2, 0, Ranking::equalsCount);

	private final int sameCount;
	private final long prizeMoney;
	private BiPredicate<Ranking, WinningArgument> argumentEqualsArgumentsOfRanking;

	public static Ranking getRakingOf(WinningArgument argument) {
		if (FAILURE.sameCount >= argument.getSameCount()) {
			return Ranking.FAILURE;
		}

		return Stream.of(Ranking.values())
					 .filter(ranking -> ranking.argumentEqualsArgumentsOfRanking.test(ranking, argument))
					 .findFirst()
					 .get();
	}

	private static boolean equalsCount(Ranking ranking, WinningArgument argument) {
		return ranking.sameCount == argument.getSameCount();
	}

	private static boolean equalsSecondRanking(Ranking ranking, WinningArgument argument) {
		return equalsCount(ranking, argument) && argument.isMatchBonusBall();
	}

	private static boolean equalsThirdRanking(Ranking ranking, WinningArgument argument) {
		return equalsCount(ranking, argument) && !argument.isMatchBonusBall();
	}


}
