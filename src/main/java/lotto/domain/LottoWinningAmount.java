package lotto.domain;

import java.util.Arrays;

public enum LottoWinningAmount {
    NONE(0, 0),
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    SIX_MATCH(6, 2000000000);

    private Integer matchCount;
    private Long winningAmount;

    LottoWinningAmount(int matchCount, long winningAmount) {
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
    }

    public long getWinningAmount() {
        return winningAmount;
    }

    public static LottoWinningAmount find(long matchCount) {
        return Arrays.stream(LottoWinningAmount.values())
                .filter(amount -> amount.matchCount == matchCount)
                .findFirst().orElse(NONE);
    }
}
