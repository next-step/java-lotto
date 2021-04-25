package step4.lotto.domain;

import java.util.Arrays;
import java.util.stream.Stream;

public enum Rank {
    FIRST(6,2_000_000_000),
    SECOND(5,30_000_000),
    THIRD(5,15_000_000),
    FOURTH(4,50_000),
    FIFTH(3,5_000),
    MISS(0,0);

    private int matchCount;
    private int winigMoney;

    Rank(int matchCount, int winigMoney) {
        this.matchCount = matchCount;
        this.winigMoney = winigMoney;
    }

    public static Rank rank(int matchCount, boolean matchBonus) {
        if(SECOND.matchCount == matchCount ){
            return rankSecondAndThird(matchBonus);
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.isMatchCount(matchCount))
                .findFirst()
                .orElse(Rank.MISS);
    }

    private static Rank rankSecondAndThird(boolean matchBonus) {
        if(matchBonus){
            return SECOND;
        }
        return THIRD;
    }

    private boolean isMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinigMoney() {
        return winigMoney;
    }
}
