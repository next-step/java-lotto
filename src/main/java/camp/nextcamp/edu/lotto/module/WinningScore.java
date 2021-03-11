package camp.nextcamp.edu.lotto.module;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum WinningScore {
	NONE(0, 0),
	THREE(3, 5_000),
	FOUR(4, 50_000),
	FIVE(5, 1_500_000),
	SIX(6, 2_000_000_000);

	private final int correctCount;
	private final int price;

	WinningScore(int correctCount, int price) {
		this.correctCount = correctCount;
		this.price = price;
	}

	public int getCorrectCount() {
		return correctCount;
	}

	public int getPrice() {
		return price;
	}

	public static WinningScore getInstance(int correctCount) {
		return Arrays.stream(values())
			.filter((winning) -> winning.correctCount == correctCount)
			.findFirst()
			.orElse(NONE);
	}

	public static List<WinningScore> getAllExactWinningCount(Map<WinningScore, Long> countByMap) {
		return Arrays.stream(values())
			.filter(winningScore -> !countByMap.keySet().contains(winningScore))
			.collect(Collectors.toList());
	}
}
