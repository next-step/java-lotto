package lotto.constant;

import java.util.Arrays;

public enum LottoRanking {
    MISS(0, 0),
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000),
    ;

    private final int ranking;
    private final int award;

    LottoRanking(int ranking, int award) {
        this.ranking = ranking;
        this.award = award;
    }

    public static LottoRanking of(int matchCount) {
        return Arrays.stream(LottoRanking.values())
                .filter(value -> value.ranking == matchCount)
                .findFirst()
                .orElse(MISS);
    }

    public int getAward() {
        return award;
    }

    public int getRanking() {
        return ranking;
    }
}

