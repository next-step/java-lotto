package step2.constants;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum PrizeGrade {

	FIRST(6, 2000000000, 4),
	SECOND(5, 1500000, 3),
	THIRD(4, 50000, 2),
	FOURTH(3, 5000, 1),
	FAIL(-1, 0, 999999999);

	private final int matchCount;

	private final int reward;

	private final int printOrder;

	private static final Map<Integer, PrizeGrade> valuesMap = Arrays.stream(PrizeGrade.values()).collect(Collectors.toMap(prizeGrade -> prizeGrade.matchCount, Function.identity()));

	PrizeGrade(int matchCount, int reward, int printOrder) {
		this.matchCount = matchCount;
		this.reward = reward;
		this.printOrder = printOrder;
	}

	public static PrizeGrade of(int matchCount) {
		return Optional.ofNullable(valuesMap.get(matchCount))
						.orElseGet(() -> FAIL);
	}

	public int getMatchCount() {
		return matchCount;
	}

	public int getReward() {
		return reward;
	}

	public int getPrintOrder() {
		return printOrder;
	}
}
