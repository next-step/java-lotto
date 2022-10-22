package lotto.domain;

import java.util.Arrays;

public enum RankingAward {

    FIRST(6, 2_000_000_000),
    SECOND(7, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
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
