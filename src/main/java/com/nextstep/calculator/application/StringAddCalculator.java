package com.nextstep.calculator.application;

import com.nextstep.calculator.domain.*;
import com.nextstep.calculator.domain.Number;

public class StringAddCalculator {
    public static Integer splitAndSum(final String value) {
        if (value == null || value.isEmpty()) {
            return 0;
        }

        Mode mode = selectMode(value);

        return calculate(mode);
    }

    private static Mode selectMode(final String value) {
        ModeSelector modeSelector = new ModeSelector(value);
        return modeSelector.select();
    }

    private static Integer calculate(final Mode mode) {
        NumberSeparator numberSeparator = new NumberSeparator(mode);
        Numbers numbers = numberSeparator.separateNumbers();
        Number sum = numbers.sum();

        return sum.getValue();
    }
}
