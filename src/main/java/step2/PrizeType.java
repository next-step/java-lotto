package step2;

import stringCalculator.Operator;

import java.util.Arrays;
import java.util.function.Function;

public enum PrizeType {

    THREE(3, value -> value * 5000),
    FOUR(4, value -> value * 50000),
    FIVE(5, value -> value * 1500000),
    SIX(6, value -> value * 2000000000),
    UNKNOWN(0, null);


    private final Function<Integer, Integer> run;
    private final int matchCount;

    PrizeType(int matchCount, Function<Integer, Integer> run) {
        this.run = run;
        this.matchCount = matchCount;
    }

    public int calculate(int value){
        return run.apply(value);
    }

    public static PrizeType findPrizeType(int winningCount) {
        return Arrays.stream(PrizeType.values())
                .filter(type -> type.matchCount != 0)
                .filter(type -> type.matchCount == winningCount)
                .findFirst()
                .orElse(PrizeType.UNKNOWN);
    }
}
