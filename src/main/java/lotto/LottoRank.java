package lotto;

import java.util.Arrays;
import java.util.function.Supplier;

public enum LottoRank {
    NONE(0, () -> 0L),
    THREE(3, () -> 5_000L),
    FOUR(4, () -> 50_000L),
    FIVE(5, () -> 1_500_000L),
    SIX(6, () -> 2_000_000_000L);

    private final int winningCount;
    private final Supplier<Long> expression;

    LottoRank(int winningCount, Supplier<Long> expression) {
        this.winningCount = winningCount;
        this.expression = expression;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public static LottoRank getLottoRank(int winningCount) {
        return Arrays.stream(values())
                .filter(lottoRank -> lottoRank.getWinningCount() == winningCount)
                .findFirst()
                .orElse(LottoRank.NONE);
    }

    public long reward() {
        return expression.get();
    }


}
