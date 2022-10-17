package lotto.constant;

import java.util.Arrays;

public enum LottoRanking {

    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000),
    ;

    private final int ranking;
    private final int award;

    LottoRanking(int ranking, int award) {
        this.ranking = ranking;
        this.award = award;
    }

    public static int getAward(int ranking) {
        LottoRanking rankingAward = Arrays.stream(LottoRanking.values())
                .filter(value -> value.ranking == ranking)
                .findFirst().orElseThrow(IllegalArgumentException::new);
        return rankingAward.award;
    }

}
