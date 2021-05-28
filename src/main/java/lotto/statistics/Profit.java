package lotto.statistics;

import java.util.Arrays;
import java.util.function.Predicate;

public enum Profit {

    PROFIT_MESSAGE((ratio) -> ratio > 1, "이익"),
    BREAK_EVENT_MESSAGE((ratio) -> ratio == 1, "본전"),
    LOSS_MESSAGE((ratio) -> ratio < 1, "손해");

    private final Predicate<Double> predicate;
    private final String description;

    Profit(Predicate<Double> predicate, String description) {
        this.predicate = predicate;
        this.description = description;
    }

    public static String messageByRatio(double ratio) {
        return Arrays.stream(values())
            .filter(a -> a.predicate.test(ratio))
            .findAny()
            .get()
            .description;
    }

}
