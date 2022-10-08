package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THRID(4, 50000),
    FOURTH(3, 5000),
    NONE(0, 0),
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
