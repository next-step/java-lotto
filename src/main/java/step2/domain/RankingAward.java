package step2.domain;

import java.util.Arrays;

public enum RankingAward {

    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000),
    ;

    private final int ranking;
    private final int award;

    RankingAward(int ranking, int award) {
        this.ranking = ranking;
        this.award = award;
    }

    public static int getAward(int ranking) {
        RankingAward rankingAward = Arrays.stream(RankingAward.values())
                .filter(value -> value.ranking == ranking)
                .findFirst().orElseThrow(IllegalArgumentException::new);
        return rankingAward.award;
    }

}
