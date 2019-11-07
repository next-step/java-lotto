package lotto.domain;

import java.util.Arrays;

public enum LottoWinningAmount {

    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    FIRST(6, 2000000000),
    LOSING_TICKET(0, 0);

    private int matchCount;
    private int amount;

    LottoWinningAmount(int matchCount, int amount) {
        this.matchCount = matchCount;
        this.amount = amount;
    }

    public static LottoWinningAmount findWinningAmount(int matchCount) {
        return Arrays.stream(values())
                .filter(lottoWinningAmount -> lottoWinningAmount.matchCount == matchCount)
                .findFirst()
                .orElse(LOSING_TICKET);
    }

    public boolean isEqualMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }


}
