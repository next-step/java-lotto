package step1;

import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern pattern = Pattern.compile("^[0-9]*$");

    public static int calculate(Formulas formulas) {
        if (formulas.isEmpty()) {
            return 0;
        }
        int result = 0;
        for (String operand : formulas.getFormulas()) {
            result += toNumber(operand);
        }
        return result;
    }

    private static int toNumber(String operand) {
        if (pattern.matcher(operand).find()) {
            return Integer.parseInt(operand);
        }
        throw new RuntimeException("숫자 이외의 값 또는 음수는 입력할 수 없습니다.");
    }

}
