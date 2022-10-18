package lotto.domain;

import java.util.Arrays;

public enum RankingAward {

    FIST(6, 2000000000),
    SECOND(7, 30000000),
    THIRD(5, 1500000),
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
