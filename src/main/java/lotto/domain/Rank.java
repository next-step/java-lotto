package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(2000000000, 6),
    SECOND(1500000, 5),
    THIRD(50000, 4),
    FOURTH(5000, 3),
    NOTHING(0, 0);

    private int rewards;
    private int match;

    Rank(int rewards, int match) {
        this.rewards = rewards;
        this.match = match;
    }

    static Rank findRank(int match) {
        if (match < 3) return NOTHING;
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.getMatch() == match)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("맞는 랭크가 없습니다."));
    }

    public int getMatch() {
        return match;
    }

    public int getRewards() {
        return rewards;
    }
}
