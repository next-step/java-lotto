package caculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class StringCalculator {

    public static final int MINIMUM_FORMULA = 3;
    public static final int EVEN = 2;
    public static final int ODD_RESULT = 1;
    public static final int FIRST_NUMBER = 0;
    public static final int FIRST_SIGN = 1;
    public static final int SECOND_NUMBER = 2;
    public static final int NEXT_NUMBER = 1;
    public static final int SECOND_FORMULA_INDEX = 3;
    public static final int NEXT_FORMULA_INDEX = 2;

    public int calculate(int numberOne, String sign, int numberTwo) {
        CalculatorType calculatorType = CalculatorType.selectType(sign);
        return calculatorType.calculate(numberOne, numberTwo);
    }

    public int playCalculate(String inputString) {
        if (Objects.isNull(inputString)) {
            throw new IllegalArgumentException("입력값이 Null 이면 안됩니다.");
        }
        if (inputString.isEmpty()) {
            throw new IllegalArgumentException("입력값이 공백이면 안됩니다.");
        }
        List<String> inputStrings = Arrays.asList(inputString.split(" "));

        if (!isNormalFormula(inputStrings.size())) {
            throw new IllegalArgumentException("제대로된 계산식을 입력하여 주세요.");
        }

        int result = calculate(Integer.parseInt(inputStrings.get(FIRST_NUMBER)),
                inputStrings.get(FIRST_SIGN),
                Integer.parseInt(inputStrings.get(SECOND_NUMBER)));

        for (int i = SECOND_FORMULA_INDEX; i < inputStrings.size() - 1; i += NEXT_FORMULA_INDEX) {
            result = calculate(result,
                    inputStrings.get(i),
                    Integer.parseInt(inputStrings.get(i + NEXT_NUMBER)));
        }
        return result;
    }

    private boolean isNormalFormula(int listSize) {
        return (listSize >= MINIMUM_FORMULA && isOdd(listSize));
    }

    private boolean isOdd(int listSize) {
        return listSize % EVEN == ODD_RESULT;
    }
}
