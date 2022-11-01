package step3.model.winning;

import java.util.Arrays;
import java.util.stream.Stream;

public enum Rank {

	FIRST(6, false, 2_000_000_000),
	SECOND(5, false, 30_000_000),
	THIRD(5, true, 1_500_000),
	FOURTH(4, false, 50_000),
	FIFTH(3, false, 5_000),
	MISS(0, false,  0);

	private int countOfMatch;		// 일치하는 개수
	private boolean matchBonus;		// 일치하는 개수
	private int winningMoney;		// 당첨 상금

	private Rank(int countOfMatch, boolean matchBonus, int winningMoney) {
		this.countOfMatch = countOfMatch;
		this.matchBonus = matchBonus;
		this.winningMoney = winningMoney;
	}

	public int getCountOfMatch() {
		return countOfMatch;
	}

	public int getWinningMoney() {
		return winningMoney;
	}

	public boolean getMatchBonus() {
		return matchBonus;
	}

	public static Rank valueOf(int countOfMatch, boolean matchBonus) {
		return Arrays.stream(values())
			.filter(rank -> rank.getCountOfMatch() == countOfMatch)
			.filter(rank -> rank.getMatchBonus() == matchBonus)
			.findAny()
			.orElse(Rank.MISS);
	}

	public static Stream<Rank> stream() {
		return Arrays.stream(values());
	}
}