package study.calculator;

import static study.calculator.Validator.isNotNullAndIsBlank;

public final class StringAddCalculator {

    public static int splitAndSum(String text) {
        if(isNotNullAndIsBlank(text)) { // null 또는 "" 처리
            return 0;
        }
        Numbers numberManager = Numbers.of(text);
        return numberManager.sumNumbers();
    }
}
