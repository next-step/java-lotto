package me.devyonghee.calculator;

import me.devyonghee.common.Assert;
import me.devyonghee.common.StringSeparator;

final class CalculationUtils {

    private CalculationUtils() {
        throw new AssertionError();
    }

    static int calculate(String string) {
        Assert.hasText(string, "string to calculate must be provided");
        return StringCalculator.from(StringSeparator.from(string)).calculatedNumber()
                .value();
    }
}
