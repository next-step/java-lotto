package step2.domain.type;

import step2.exception.NotFoundPrizeException;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public enum Prize {

    NO_PRIZE(0, BigDecimal.ZERO, (count, bonus) -> count <= 2),
    FIFTH(3, BigDecimal.valueOf(5000), (count, bonus) -> count == 3),
    FOURTH(4, BigDecimal.valueOf(50000), (count, bonus) -> count == 4),
    THIRD(5, BigDecimal.valueOf(1500000), (count, bonus) -> count == 5 && !bonus),
    SECOND(5, BigDecimal.valueOf(30000000), (count, bonus) -> count == 5 && bonus),
    FIRST(6, BigDecimal.valueOf(2000000000), (count, bonus) -> count == 6);

    private static final List<Prize> WINNING = Arrays.asList(FIRST, SECOND, THIRD, FOURTH, FIFTH);

    private final int matchCount;
    private final BigDecimal prizeMoney;
    private final BiFunction<Integer, Boolean, Boolean> expression;

    Prize(int matchCount, BigDecimal prizeMoney, BiFunction<Integer, Boolean, Boolean> expression) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.expression = expression;
    }

    public boolean prize(int matchCount, boolean isBonusMatched) {
        return expression.apply(matchCount, isBonusMatched);
    }

    public static Prize of(int matchCount, boolean isBonusMatched) {
        return Arrays.stream(Prize.values())
            .filter(prize -> prize.prize(matchCount, isBonusMatched))
            .findFirst()
            .orElseThrow(() -> new NotFoundPrizeException());
    }

    public boolean isWinningPrize() {
        return WINNING.contains(this);
    }

    public int matchCount() {
        return this.matchCount;
    }

    public BigDecimal prizeMoney() {
        return this.prizeMoney;
    }

}
