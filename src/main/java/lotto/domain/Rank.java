package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST("2000000000원", 6),
    SECOND("1500000원", 5),
    THIRD("50000원", 4),
    FOURTH("5000원", 3);

    private String rewards;
    private int match;

    Rank(String rewards, int match) {
        this.rewards = rewards;
        this.match = match;
    }

    static Rank findRank(int match) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.getMatch() == match)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("맞는 랭크가 없습니다."));
    }

    public int getMatch() {
        return match;
    }
}
