package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    NONE(0, 0),
    FOURTH(3, 5_000),
    THRID(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000),
    ;

    private final int correctNum;
    private final int winPrize;

    LottoRank(int correctNum, int winPrize) {
        this.correctNum = correctNum;
        this.winPrize = winPrize;
    }

    public static LottoRank findRank(Integer correctNum) {
         return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.correctNum == correctNum)
                .findFirst()
                .orElseGet(() -> NONE);
    }

    public int getCorrectNum() {
        return correctNum;
    }

    public int getWinPrize() {
        return winPrize;
    }
}
