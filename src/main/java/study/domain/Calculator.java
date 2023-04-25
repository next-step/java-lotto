package study.domain;

import study.domain.util.FormulaParser;

import java.util.regex.Pattern;

public class Calculator {

    private static final Pattern REG_EXP = Pattern.compile("^\\d+$");

    private static final String INVALID_FORMULA = "입력수식이 잘못되었습니다.";

    private final FormulaParser formulaParser;

    private Operator currentOperator;

    public Calculator(final FormulaParser formulaParser) {
        this.formulaParser = formulaParser;
    }

    public int calculate() {
        int result = 0;
        int validCount = 0;

        // 첫번째 연산자는 초기화 ( 초기할당 )
        Operator currentOperator = Operator.PLUS;

        for (String param : formulaParser.getFormula()) {
            validFormula(validCount);
            // 숫자인 경우
            if (isNumber(param)) {
                result = currentOperator.calculate(result, stringToInt(param));
                validCount -= 1;
            }
            // 연산자인 경우
            if (!isNumber(param)) {
                currentOperator = Operator.getSymbol(param);
                validCount += 1;
            }
        }

        return result;
    }

    private static void validFormula(final int validCount) {
        if(validCount >= 2 || validCount < 0) {
            throw new IllegalArgumentException(INVALID_FORMULA);
        }
    }

    private static boolean isNumber(final String param) {
        return REG_EXP.matcher(param).find();
    }

    private static int stringToInt(final String param) {
        return Integer.parseInt(param);
    }

}