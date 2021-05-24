package kr.aterilio.nextstep.techcamp.m1.calculator;

public class StringAddCalculator {

    private static final int RESULT_NONE = 0;

    public static int splitAndSum(String formula) {
        if (StringUtil.isEmpty(formula)) {
            return RESULT_NONE;
        }
        Integer[] units = Parser.parse(formula);
        return AddCalculator.calculate(units);
    }
}
