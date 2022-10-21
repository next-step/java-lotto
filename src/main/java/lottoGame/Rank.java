package lottoGame;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;

public enum Rank {
    NONE(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private Integer matchNum;
    private Integer rank;

    Rank(Integer mathNum, Integer rank) {
        this.matchNum = mathNum;
        this.rank = rank;
    }

    public Rank findRank(int matchNumber, boolean bonus) {

        return Arrays.stream(values())
                .filter(rank1 -> rank1.matchNum == matchNumber)
                .map(checkSecond(bonus))
                .findAny()
                .orElse(NONE);
    }

    private static Function<Rank, Rank> checkSecond(boolean bonus) {
        return rank1 -> {
            if (bonus && rank1.matchNum == SECOND.getMatchNum()) {
                return SECOND;
            }
            return rank1;
        };
    }


    public Integer getMatchNum() {
        return matchNum;
    }

    public Integer getRank() {
        return rank;
    }


}
