package lotto.domain;

import java.util.Arrays;

public enum LottoRanking {

    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    NOT_MATCH(0, 0);

    private final int countOfMatch;
    private final int prize;

    LottoRanking(int countOfMatch, int prize) {
        this.countOfMatch = countOfMatch;
        this.prize = prize;
    }

    public static LottoRanking valueOf(int countOfMatch) {
        return Arrays.stream(values())
                .filter(ranking -> ranking.countOfMatch == countOfMatch)
                .findFirst()
                .orElse(NOT_MATCH);
    }

    public int getPrize() {
        return prize;
    }
}
