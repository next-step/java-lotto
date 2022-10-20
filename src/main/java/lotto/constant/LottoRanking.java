package lotto.constant;

import java.util.Arrays;

public enum LottoRanking {

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

    public static int getAward(int ranking) {
        LottoRanking rankingAward = Arrays.stream(LottoRanking.values())
                .filter(value -> value.ranking == ranking)
                .findFirst().orElseThrow(() -> new IllegalArgumentException(String.format("%d에 해당하는 값을 찾을 수 없습니다.", ranking)));
        return rankingAward.award;
    }

}
