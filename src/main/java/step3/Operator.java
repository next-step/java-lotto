package step3;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operator {
	THREE(3, 5000),
	FOUR(4, 50000),
	FIVE(5, 1500000),
	SIX(6, 2000000000);

	private int count;
	private int winning;

	private static final Map<Integer, Operator> RANK_MAP = Collections.unmodifiableMap(
		Stream.of(values())
			.collect(Collectors.toMap(Operator::getCount, Function.identity()))
	);

	Operator(int count, int winning) {
		this.count = count;
		this.winning = winning;
	}

	public static Operator find(Integer count) {
		if (!RANK_MAP.containsKey(count)) {
			return null;
		}
		return RANK_MAP.get(count);
	}

	public int getCount() {
		return count;
	}

	public int getWinning() {
		return winning;
	}
}
