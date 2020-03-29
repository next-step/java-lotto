package lotto.domain;

import java.math.BigDecimal;
import java.util.Arrays;

public enum WinningType {
    THREE_MATCH(3, BigDecimal.valueOf(5000)),
    FOUR_MATCH(4, BigDecimal.valueOf(50000)),
    FIVE_MATCH(5, BigDecimal.valueOf(1500000)),
    SIX_MATCH(6, BigDecimal.valueOf(2000000000));

    private int matchCount;
    private BigDecimal amount;

    WinningType(BigDecimal amount) {
        this.amount = amount;
    }

    WinningType(int matchCount, BigDecimal amount) {
        this.matchCount = matchCount;
        this.amount = amount;
    }

    public static WinningType findLottoWinningtype(long matchCount) {
        return Arrays.asList(values()).stream()
                .filter(lottoMatchType -> isEqualMatchCount(matchCount, lottoMatchType))
                .findFirst()
                .orElse(null);
    }

    private static boolean isEqualMatchCount(long matchCount, WinningType lottoMatchType) {
        return lottoMatchType.matchCount == matchCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public BigDecimal getWinningAmount() {
        return amount;
    }
}
