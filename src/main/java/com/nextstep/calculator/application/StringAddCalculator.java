package com.nextstep.calculator.application;

import com.nextstep.calculator.domain.Mode;
import com.nextstep.calculator.domain.ModeSelector;
import com.nextstep.calculator.domain.Number;
import com.nextstep.calculator.domain.Numbers;

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
        Numbers numbers = mode.parseToNumbers();
        Number sum = numbers.sum();

        return sum.getValue();
    }
}
