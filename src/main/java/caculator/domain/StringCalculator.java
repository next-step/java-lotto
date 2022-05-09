package caculator.domain;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    public static final int WRONG_RESULT = 0;
    public static final int MINIMUM_FORMULA = 3;
    public static final int EVEN = 2;
    public static final int ODD_RESULT = 1;
    public static final int FIRST_NUMBER = 0;
    public static final int FIRST_SIGN = 1;
    public static final int SECOND_NUMBER = 2;

    public int calculate(int numberOne, String sign, int numberTwo) {
        if (isNotSign(sign)) {
            throw new IllegalArgumentException("제대로된 사칙연산기호를 입력해 주세요. 입력 값: " + sign);
        }

        if (sign.equals("+")) {
            return numberOne + numberTwo;
        }
        if (sign.equals("-")) {
            return numberOne - numberTwo;
        }
        if (sign.equals("*")) {
            return numberOne * numberTwo;
        }
        if (sign.equals("/")) {
            return numberOne / numberTwo;
        }
        return WRONG_RESULT;
    }

    public int playCalculate(String inputString) {
        if (isNull(inputString)) {
            throw new IllegalArgumentException("입력값이 Null 이면 안됩니다.");
        }
        if (isBlank(inputString)) {
            throw new IllegalArgumentException("입력값이 공백이면 안됩니다.");
        }

        List<String> inputStringList = Arrays.asList(inputString.split(" "));

        if (!isNormalFormula(inputStringList.size())) {
            throw new IllegalArgumentException("제대로된 계산식을 입력하여 주세요.");
        }

        int result = calculate(Integer.parseInt(inputStringList.get(FIRST_NUMBER)),
                inputStringList.get(FIRST_SIGN),
                Integer.parseInt(inputStringList.get(SECOND_NUMBER)));

        for (int i = 3; i < inputStringList.size() - 1; i += 2) {
            result = calculate(result,
                    inputStringList.get(i),
                    Integer.parseInt(inputStringList.get(i + 1)));
        }
        return result;
    }

    private boolean isBlank(String string) {
        return string == "";
    }

    private boolean isNull(String string) {
        return string == null;
    }

    private boolean isNotSign(String sign) {
        return !sign.equals("+") && !sign.equals("-") && !sign.equals("*") && !sign.equals("/");
    }

    private boolean isNormalFormula(int listSize) {
        return (listSize >= MINIMUM_FORMULA && isOdd(listSize));

    }

    private boolean isOdd(int listSize) {
        return listSize % EVEN == ODD_RESULT;
    }
}
