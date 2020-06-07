package study2.domain;

import java.util.Arrays;
import java.util.List;

public class Ranking {
	
	public enum Rank {
	FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private int countOfMatch;
    private int winningMoney;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }
	};
	
	
	public static int[] winNumSplit(String winNumber) {
		return Arrays.stream(winNumber.split(",")).
				mapToInt(Integer::parseInt)
				.toArray();
	}
	
	
}
