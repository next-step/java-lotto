package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {

    NOTHING(0, 0),
    FIFTH(5_000, 3),
    FOURTH(50_000, 4),
    THIRD(1_500_000, 5),
    SECOND(30_000_000, 5),
    FIRST(2_000_000_000, 6);

    private int rewards;
    private int match;

    Rank(int rewards, int match) {
        this.rewards = rewards;
        this.match = match;
    }

    static Rank findRank(int countOfMatch, boolean matchBonus) {
        if (matchBonus && countOfMatch == SECOND.getMatch()) {
            return SECOND;
        }
        if (countOfMatch < 3) {
            return NOTHING;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.getMatch() == countOfMatch)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("맞는 랭크가 없습니다."));
    }

    public static List<Rank> valuesExcludeNoRewards() {
        return Arrays.stream(Rank.values())
                .filter(rank -> !rank.equals(Rank.NOTHING))
                .collect(Collectors.toList());
    }

    public int getMatch() {
        return match;
    }

    public int getRewards() {
        return rewards;
    }

}
