package lotto.domain;

import java.util.Arrays;

public enum Match {
    MATCH_3(3, 5000),
    MATCH_4(4, 50000),
    MATCH_5(5, 1500000),
    MATCH_6(6, 2000000000),
    MISS(0,0);

    private final long matchCount;
    private final long reward;

    Match(long matchCount, long reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public long getMatchCount() {
        return matchCount;
    }

    public long getReward() {
        return reward;
    }

    /**
     * 맞춘 갯수 반환
     * @param count 맞힌 갯수
     * @return Match
     */
    public static Match getMatchInfo(long count) {
        return Arrays.stream(Match.values())
                .filter(Rank -> Rank.getMatchCount() == count)
                .findFirst()
                .orElse(MISS);
    }
}
