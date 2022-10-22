package autoLotto;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000, 0),
    SECOND(5, 30_000_000, 0),
    THIRD(5, 1_500_000, 0),
    FOURTH(4, 50_000, 0),
    FIFTH(3, 5_000, 0),
    MISS(0, 0, 0);

    private static final int SECOND_RANK = 1;
    private static final int THIRD_RANK = 2;
    private static final int MISS_RANK = 5;
    private static final int FIVE_MATCHES = 5;


    private int countOfMatch;
    private int winningMoney;
    private int countOfRank;

    private Rank(int countOfMatch, int winningMoney, int countOfRank) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.countOfRank = countOfRank;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public int getCountOfRank() {
        return countOfRank;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        Rank[] ranks = values();
        
        if (isFiveMatches(countOfMatch)) {
            return getSecondOrThirdRank(ranks, matchBonus);
        }

        return Arrays.stream(ranks)
                .filter(rank -> isCountOfMatch(countOfMatch, rank))
                .findFirst()
                .orElse(ranks[MISS_RANK]);
    }

    private static boolean isCountOfMatch(int countOfMatch, Rank rank) {
        return rank.getCountOfMatch() == countOfMatch;
    }

    private static boolean isFiveMatches(int countOfMatch) {
        return countOfMatch == FIVE_MATCHES;
    }
    
    private static Rank getSecondOrThirdRank(Rank[] ranks, boolean matchBonus) {
        if (matchBonus == true) {
            return getSecondRank(ranks);
        }
        return getThirdRank(ranks);
    }

    private static Rank getThirdRank(Rank[] ranks) {
        Rank rank = ranks[THIRD_RANK];
        rank.countOfRank();
        return ranks[THIRD_RANK];
    }

    private static Rank getSecondRank(Rank[] ranks) {
        Rank rank = ranks[SECOND_RANK];
        rank.countOfRank();
        return ranks[SECOND_RANK];
    }

    private void countOfRank() {
        this.countOfRank++;
    }
}
