package step3.model.result;

import java.util.Arrays;
import java.util.stream.Stream;

public enum Rank {

	FIRST(6, 2_000_000_000),
	SECOND(5, 30_000_000),
	THIRD(5, 1_500_000),
	FOURTH(4, 50_000),
	FIFTH(3, 5_000),
	MISS(0,  0);

	private int countOfMatch;		// 일치하는 개수
	private int winningMoney;		// 당첨 상금

	private Rank(int countOfMatch, int winningMoney) {
		this.countOfMatch = countOfMatch;
		this.winningMoney = winningMoney;
	}

	public int getCountOfMatch() {
		return countOfMatch;
	}

	public int getWinningMoney() {
		return winningMoney;
	}

	public static Rank valueOf(int countOfMatch, boolean matchBonus) {
		if (isSecond(countOfMatch, matchBonus)) {
			return Rank.SECOND;
		}

		return Arrays.stream(values())
			.filter(rank -> rank.getCountOfMatch() == countOfMatch)
			.findAny()
			.orElse(Rank.MISS);
	}

	public static Stream<Rank> stream() {
		return Arrays.stream(values());
	}

	private static boolean isSecond(int countOfMatch, boolean matchBonus) {
		return countOfMatch == Rank.SECOND.getCountOfMatch() && matchBonus;
	}
}