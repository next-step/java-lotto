package com.hskim.lotto.calculator;

import com.hskim.lotto.model.PositiveNumberTokens;

public class StringAddCalculator {

    public int calculate(PositiveNumberTokens positiveNumberExpr) {

        return positiveNumberExpr.getTokenList().stream()
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
    }
}
