package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    BLANK(0,    new Price(0))
    , FOURTH(3, new Price(5_000))
    , THIRD(4,  new Price(50_000))
    , SECOND(5, new Price(1_500_000))
    , SECOND_BONUS(5, new Price(30_000_000))
    , FIRST(6,  new Price(2_000_000_000))
    ;

    private int matchCount;
    private Price winPrice;

    LottoRank(final int matchCount, final Price winPrice) {
        this.matchCount = matchCount;
        this.winPrice = winPrice;
    }

    public static LottoRank findRank(int matchCount, boolean matchBonus) {
        LottoRank rank = Arrays.stream(LottoRank.values())
                               .filter(lottoRank -> lottoRank.matchCount == matchCount)
                               .findFirst()
                               .orElse(LottoRank.BLANK);

        if (rank.isSecondBonus(matchBonus)) {
            return LottoRank.SECOND_BONUS;
        }
        return rank;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public Price getRankPrice() {
        return winPrice;
    }

    private boolean isSecondBonus(final boolean matchBonus) {
        return this.equals(LottoRank.SECOND) && matchBonus;
    }
}
