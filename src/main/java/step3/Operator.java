package step3;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operator {
	NOT_RANK(0, null, 0),
	THREE(3, false, 5000),
	FOUR(4, false, 50000),
	FIVE(5, false, 1500000),
	FIVE_BONUS(5, true, 30000000),
	SIX(6, false, 2000000000);

	private int count;
	private int winning;
	private Boolean bonusCheck;

	// private static final Map<Integer, Operator> RANK_MAP = Collections.unmodifiableMap(
	// 	Stream.of(values())
	// 		.collect(Collectors.toMap(Operator::getCount, Function.identity()))
	// );

	Operator(int count, Boolean bonusCheck, int winning) {
		this.count = count;
		this.bonusCheck = bonusCheck;
		this.winning = winning;
	}

	public static Operator find(int count, boolean bonus) {
		return Arrays.stream(values())
			.filter(ranks -> isRank(ranks, count, bonus))
			.findFirst()
			.orElse(NOT_RANK);
	}

	private static boolean isRank(Operator rank, int count, boolean bonus) {
		if (rank.bonusCheck != null) {
			return rank.count == count && rank.bonusCheck == bonus;
		}
		return rank.count == count;
	}

	public int getCount() {
		return count;
	}

	public int getWinning() {
		return winning;
	}
}
