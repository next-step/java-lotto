package com.kakao.stringadder.domain.calculator;

import com.kakao.stringadder.domain.splitter.ExpressionParser;

import java.util.List;

public class StringAddCalculator {

    private StringAddCalculator() {
    }

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        List<String> calculationInput = ExpressionParser.parse(input);
        OperandCollection operandCollection = OperandCollection.of(calculationInput);
        return operandCollection.plusAll().getValue();
    }
}
