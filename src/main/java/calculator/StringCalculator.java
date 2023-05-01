package calculator;

import java.util.regex.Pattern;

public class StringCalculator {
    public int calculation(String formula) {
        checkEmptyString(formula);
        String[] arrFormula = splitFormula(formula);
        for (int i = 1; i < arrFormula.length; i += 2) {
            //연산
            String[] subFormula = {arrFormula[i - 1], arrFormula[i], arrFormula[i + 1]};
            validateSubFormula(subFormula);
            arrFormula[i + 1] = Integer.toString(operation(subFormula));
        }
        int result = Integer.parseInt(arrFormula[arrFormula.length - 1]);
        return result;
    }

    private String[] splitFormula(String formula) {
        return formula.split(" ");
    }

    private int operation(String[] arrFormula) {
        int preNum = Integer.parseInt(arrFormula[0]);
        int postNum = Integer.parseInt(arrFormula[2]);
        String operator = arrFormula[1];

        if ("+".equals(operator)) {
            return Operation.plus(preNum, postNum);
        }
        if ("-".equals(operator)) {
            return Operation.minus(preNum, postNum);
        }
        if ("*".equals(operator)) {
            return Operation.multiple(preNum, postNum);
        }
        if ("/".equals(operator)) {
            return Operation.division(preNum, postNum);
        }
        return 0;
    }

    private void checkEmptyString(String formula) {
        if (formula == null || formula.isBlank()) {
            throw new IllegalArgumentException("연산식을 입력해 주시기 바랍니다.");
        }
    }

    private void validateSubFormula(String[] subFormula) {
        checkOperator(subFormula[1]);
        checkNumber(subFormula[0]);
        checkNumber(subFormula[2]);
    }

    private void checkNumber(String number) {
        if (!Pattern.matches("^[0-9]*$", number)) {
            throw new IllegalArgumentException("숫자자리에 다른 문자가 입력되었습니다.");
        }
    }

    private void checkOperator(String item) {
        if (!(item.equals("+") || item.equals("-") || item.equals("*") || item.equals("/"))) {
            throw new IllegalArgumentException("연산자 자리에 다른 문자가 입력되었습니다.");
        }
    }
}
