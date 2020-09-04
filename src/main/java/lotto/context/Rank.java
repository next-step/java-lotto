package lotto.context;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private static final int MATCH_DUPLICATE = 1;

    private int countOfMatch;
    private int winningMoney;

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

    public static Rank getRank(int countOfMatch, boolean matchBonus) {
        // TODO 일치하는 수를 로또 등수로 변경한다. enum 값 목록은 "Rank[] ranks = values();"와 같이 가져올 수 있다.
        int skipIndex = isBonus(countOfMatch, matchBonus) ? 1 : 0;
        return Arrays.stream(values())
                .filter(rank -> rank.countOfMatch == countOfMatch)
                .skip(skipIndex)
                .findFirst().get();
    }

    static boolean isBonus(int countOfMatch, boolean matchBonus) {
        return getMatchRankCount(countOfMatch) > MATCH_DUPLICATE && !matchBonus;
    }

    static int getMatchRankCount(int countOfMatch) {
        return (int) Arrays.stream(values())
                .filter(rank -> rank.countOfMatch == countOfMatch)
                .count();
    }
}
