package step2;

import stringCalculator.Operator;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;

public enum PrizeType {

    THREE(3, (value, p) -> value * p),
    FOUR(4, (value, p) -> value * p),
    FIVE(5, (value, p) -> value * p),
    SIX(6, (value, p) -> value * p),
    UNKNOWN(0, (value, p) -> value * p);


    private final BiFunction<Integer, Integer, Integer> cal;

    private final int matchCount;
    private final Prize prize;

    PrizeType(int matchCount, BiFunction<Integer, Integer, Integer> cal) {
        this.cal = cal;
        this.matchCount = matchCount;
        this.prize = new Prize(matchCount);
    }

    public int calculate(int value){
        return this.cal.apply(value, prize.findPrizeByWinningCount());
    }

    public static PrizeType findPrizeType(int winningCount) {
        return Arrays.stream(PrizeType.values())
                .filter(type -> type.matchCount != 0)
                .filter(type -> type.matchCount == winningCount)
                .findFirst()
                .orElse(PrizeType.UNKNOWN);
    }
}
