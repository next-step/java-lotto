package lotto;

import java.util.Arrays;
import java.util.function.Supplier;

public enum  LottoRank {
    NONE(0, () -> 0),
    THREE(3, () -> 5_000),
    FOUR(4, () -> 50_000),
    FIVE(5, () -> 1_500_000),
    SIX(6, () -> 2_000_000_000);

    private final int winningCount;
    private final Supplier<Integer> expression;

    LottoRank(int winningCount, Supplier<Integer> expression) {
        this.winningCount = winningCount;
        this.expression = expression;
    }

    private int getWinningCount() {
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
