package autoLotto;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private static final int SECOND_RANK = 1;
    private static final int THIRD_RANK = 2;
    private static final int MISS_RANK = 5;
    private static final int FIVE_MATCHES = 5;


    private final int countOfMatch;
    private final int winningMoney;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }


    public static int valueOf(int countOfMatch, boolean matchBonus) {
        Rank[] ranks = values();
        
        if (isFiveMatches(countOfMatch)) {
            return getSecondOrThirdRank(ranks, matchBonus);
        }

        Rank rank = Arrays.stream(ranks)
                .filter(r -> isCountOfMatch(countOfMatch, r))
                .findFirst()
                .orElse(ranks[MISS_RANK]);

        RankMap.count(rank);

        return rank.winningMoney;
    }

    private static boolean isCountOfMatch(int countOfMatch, Rank rank) {
        return rank.getCountOfMatch() == countOfMatch;
    }

    private static boolean isFiveMatches(int countOfMatch) {
        return countOfMatch == FIVE_MATCHES;
    }
    
    private static int getSecondOrThirdRank(Rank[] ranks, boolean matchBonus) {
        if (matchBonus) {
            return getSecondRank(ranks[SECOND_RANK]);
        }
        return getThirdRank(ranks[THIRD_RANK]);
    }

    private static int getSecondRank(Rank rank) {
        RankMap.count(rank);
        return rank.winningMoney;
    }

    private static int getThirdRank(Rank rank) {
        RankMap.count(rank);
        return rank.winningMoney;
    }
}
