package study.domain;

import study.domain.util.FormulaParser;

import java.util.regex.Pattern;

public class Calculator {

    private static final Pattern REG_EXP = Pattern.compile("^\\d+$");

    private final FormulaParser formulaParser;

    private Operator currentOperator;

    public Calculator(final FormulaParser formulaParser) {
        this.formulaParser = formulaParser;
    }

    public int calculate() {
        int result = 0;

        // 첫번째 연산자는 초기화 ( 초기할당 )
        Operator currentOperator = Operator.PLUS;

        for (String param : formulaParser.getFormula()) {
            // 숫자인 경우
            if (isNumber(param)) {
                result = currentOperator.calculate(result, stringToInt(param));
            }
            // 연산자인 경우
            if (!isNumber(param)) {
                currentOperator = Operator.getSymbol(param);
            }
        }

        return result;
    }

    private static boolean isNumber(final String param) {
        return REG_EXP.matcher(param).find();
    }

    private static int stringToInt(final String param) {
        return Integer.parseInt(param);
    }

}