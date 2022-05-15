package lotto.util;

import lotto.model.Number;

import java.math.RoundingMode;
import java.util.function.BinaryOperator;

public class Calculator {

    private Calculator() {
    }

    private static boolean isZero(Number left, Number right) {
        return left.isZero() || right.isZero();
    }

    private static BinaryOperator<Number> calculator(BinaryOperator<Number> operator) {
        return (left, right) -> {
            if (isZero(left, right)) {
                return Number.of();
            }

            return operator.apply(left, right);
        };
    }

    public static Number add(Number left, Number right) {
        return calculator((l, r) -> Number.of(l.getValue().add(r.getValue())))
                .apply(left, right);
    }

    public static Number subtract(Number left, Number right) {
        return calculator((l, r) -> Number.of(l.getValue().subtract(r.getValue())))
                .apply(left, right);
    }

    public static Number multiply(Number left, Number right) {
        return calculator((l, r) -> Number.of(l.getValue().multiply(r.getValue())))
                .apply(left, right);
    }

    public static Number divide(Number left, Number right) {
        return calculator((l, r) -> Number.of(l.getValue().divide(r.getValue(), 2, RoundingMode.HALF_EVEN)))
                .apply(left, right);
    }

    public static Number min(Number left, Number right) {
        return calculator((l, r) -> Number.of(l.getValue().min(r.getValue())))
                .apply(left, right);
    }

    public static Number max(Number left, Number right) {
        return calculator((l, r) -> Number.of(l.getValue().max(r.getValue())))
                .apply(left, right);
    }
}
