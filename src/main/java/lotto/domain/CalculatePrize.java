package lotto.domain;

import java.util.Arrays;
import java.util.function.Function;

public enum CalculatePrize {
    FIRST(6, (number) -> 2000000000 * number),
    THIRD(5, (number) -> 1500000 * number),
    FOURTH(4, (number) -> 500000 * number),
    FIFTH(3, (number) -> 5000 * number),
    MISS(0, (number) -> 0);

    private final int matchingCount;
    private final Function<Integer, Integer> expression;

    CalculatePrize(int matchingCount, Function<Integer, Integer> expression) {
        this.matchingCount = matchingCount;
        this.expression = expression;
    }

    public int calculate(int numbers){
        return expression.apply(numbers);
    }

    public static CalculatePrize of(int matchingCount) {
        if (matchingCount < 3) {
            return MISS;
        }

        return Arrays.stream(values())
                .filter(c -> c.matchingCount == matchingCount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("0~6사이의 숫자만 입력이 가능합니다."));
    }
}
