package lotto.domain;

import java.util.Arrays;

public enum LottoPrice {
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    SIX_MATCH(6, 2000000000);

    private final int matchCount;
    private final int prizeAmount;

    LottoPrice(int matchCount, int prizeAmount) {
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public static int prizeAmount(int matchCount){
        return Arrays.stream(LottoPrice.values())
                .filter(lottoPrice -> lottoPrice.getMatchCount() == matchCount)
                .map(LottoPrice::getPrizeAmount)
                .findFirst()
                .orElse(0);
    }
}
