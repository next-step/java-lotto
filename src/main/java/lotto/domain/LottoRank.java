package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    BLANK(0,    new Price(0))
    , FOURTH(3, new Price(5_000))
    , THIRD(4,  new Price(50_000))
    , SECOND(5, new Price(1_500_000))
    , FIRST(6,  new Price(2_000_000_000))
    ;

    private int matchCount;
    private Price winPrice;

    LottoRank(final int matchCount, final Price winPrice) {
        this.matchCount = matchCount;
        this.winPrice = winPrice;
    }

    public static LottoRank findRank(int matchCount) {
        return Arrays.stream(LottoRank.values())
                     .filter(lottoRank -> lottoRank.matchCount == matchCount)
                     .findFirst()
                     .orElse(LottoRank.BLANK);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public Price getRankPrice() {
        return winPrice;
    }
}
