package Lotto.model;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000);

    private static final String RANK_ERROR_MESSAGE = "해당하는 순위가 존재하지 않습니다.";
    private final int matchCount;
    private final boolean secondAble;
    private final int reward;

    Rank(int matchCount, boolean secondAble, int reward) {
        this.matchCount = matchCount;
        this.secondAble = secondAble;
        this.reward = reward;
    }

    public static Rank getRank(int matchCount, boolean secondAble) {
        return Arrays.stream(values())
                .filter(it -> it.matchCount == matchCount && it.secondAble == secondAble)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(RANK_ERROR_MESSAGE));
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }
}
