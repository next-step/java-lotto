package study.lotto.domain;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;

public enum WinningPrize {
    FOURTH(3, BigDecimal.valueOf(5000)),
    THIRD(4, BigDecimal.valueOf(50000)),
    SECOND(5, BigDecimal.valueOf(1500000)),
    FIRST(6, BigDecimal.valueOf(2000000000));

    private int matchCount;
    private BigDecimal prize;

    WinningPrize(int matchCount, BigDecimal prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static Optional<WinningPrize> of(int matchCount) {
        return Arrays.stream(values())
                .filter(winningPrize -> winningPrize.matchCount == matchCount)
                .findFirst();
    }

    public int matchCount() {
        return matchCount;
    }

    public BigDecimal prize() {
        return prize;
    }

}
