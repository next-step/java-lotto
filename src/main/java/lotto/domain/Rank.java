package lotto.domain;

import java.util.Arrays;

public enum Rank {

    FIRST(2_000_000_000, 6),
    SECOND(1_500_000, 5),
    THIRD(50_000, 4),
    FOURTH(5_000, 3),
    LAST(0, 0);

    private final int winMoney;
    private final int winCount;

    Rank(int winMoney, int winCount) {
        this.winMoney = winMoney;
        this.winCount = winCount;
    }

    public static Rank calculateLottoRank(int winCount){
        return Arrays.stream(values())
            .filter(rank -> rank.winCount == winCount)
            .findFirst()
            .orElse(Rank.LAST);
    }

}
