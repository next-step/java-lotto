package camp.nextstep.edu.rebellion.calc;

import camp.nextstep.edu.rebellion.calc.util.StringUtil;

public class StringAddCalculator {
    private static final int ZERO = 0;

    private StringAddCalculator() {}

    public static int splitAndSum(String expression) {
        if(StringUtil.isEmpty(expression)) {
            return ZERO;
        }
        return 0;
    }
}
