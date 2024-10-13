package lotto.domain;

import java.util.Arrays;

public enum LottoRewards {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    NONE(0, 0);

    private final int matchCount;
    private final int prize;

    LottoRewards(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public static LottoRewards getLottoRewards(final int matchCount) {
        return Arrays.stream(LottoRewards.values())
                .filter(lottoRewards -> matchCount == lottoRewards.getMatchCount())
                .findFirst()
                .orElse(NONE);
    }
}
