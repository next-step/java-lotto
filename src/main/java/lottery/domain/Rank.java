package lottery.domain;

import java.util.stream.Stream;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private static final String EXCEPTION_MESSAGE_NOT_MATCH = "매칭되는 랭크 정보가 없습니다.";
    private final int countOfMatch;
    private final int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
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
        Rank matchedRank = Stream.of(values())
            .filter(rank -> rank.countOfMatch == countOfMatch)
            .findFirst()
            .orElse(MISS);

        if (matchedRank == SECOND || matchedRank == THIRD) {
            return getProperRank(matchBonus);
        }

        return matchedRank;
    }

    private static Rank getProperRank(boolean matchBonus) {
        if (matchBonus) {
            return SECOND;
        }

        return THIRD;
    }
}