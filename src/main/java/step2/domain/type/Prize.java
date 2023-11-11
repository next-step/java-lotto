package step2.domain.type;

import step2.exception.NotFoundPrizeException;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public enum Prize {

    SEVENTH(0, BigDecimal.ZERO),
    SIXTH(1, BigDecimal.ZERO),
    FIFTH(2, BigDecimal.ZERO),
    FOURTH(3, BigDecimal.valueOf(5000)),
    THIRD(4, BigDecimal.valueOf(50000)),
    SECOND(5, BigDecimal.valueOf(1500000)),
    FIRST(6, BigDecimal.valueOf(2000000000));

    private static final List<Prize> WINNING = Arrays.asList(FIRST, SECOND, THIRD, FOURTH);

    private int matchCount;
    private BigDecimal prizeMoney;

    Prize(int matchCount, BigDecimal prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static Prize of(int matchCount) {
        return Arrays.stream(Prize.values())
            .filter(prize -> prize.equalMatchCount(matchCount))
            .findFirst()
            .orElseThrow(() -> new NotFoundPrizeException());
    }

    private boolean equalMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }

    public static boolean isWinningPrize(Prize prize) {
        return WINNING.contains(prize);
    }

    public int matchCount() {
        return this.matchCount;
    }

    public BigDecimal prizeMoney() {
        return this.prizeMoney;
    }

}
