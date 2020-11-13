package calculator;

import calculator.utils.StringUtils;

public class StringCalculator {

    public int sum(String expression) {
        if( StringUtils.isNullOrBlank(expression) ) return 0;

        Expression exp = new Expression(expression);
        return exp.execute(Integer::sum);
    }
}
