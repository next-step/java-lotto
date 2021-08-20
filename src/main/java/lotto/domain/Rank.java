package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {

    NOTHING(0, 0),
    FOURTH(5000, 3),
    THIRD(50000, 4),
    SECOND(1500000, 5),
    FIRST(2000000000, 6);

    private int rewards;
    private int match;

    Rank(int rewards, int match) {
        this.rewards = rewards;
        this.match = match;
    }

    static Rank findRank(int match) {
        if (match < 3) {
            return NOTHING;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.getMatch() == match)
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
