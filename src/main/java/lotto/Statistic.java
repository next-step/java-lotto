package lotto;

import java.util.Arrays;
import java.util.function.Function;

public enum Statistic {

    THREE(5000, 3),
    FOUR(50000, 4),
    FIVE(1500000, 5),
    SIX(2000000000, 6);

    Statistic(int price, int matcher) {
        this.price = price;
        this.matcher = matcher;
    }

    private int price;
    private int matcher;

    public static Statistic valueOfMatchNumber(int featNumberCount) {
        return Arrays.stream(values())
                .filter(statistic -> statistic.matcher == featNumberCount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("당첨되지 않았습니다. 일치 : " + featNumberCount));
    }
}
