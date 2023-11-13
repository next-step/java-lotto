package calculator.domain;

import java.util.List;

public class Calculator {
    List<String> inputString;

    public Calculator(List<String> inputString) {
        this.inputString = inputString;
    }

    public int calculate() {
        int result = Integer.parseInt(inputString.get(0));
        int i = 1;
        while (i < inputString.size()) {
            result = partialCalculate(result, inputString.get(i), inputString.get(i + 1));
            i += 2;
            if ((i + 1) == inputString.size()) {
                throw new IllegalArgumentException("비정상적인 연산입니다.");
            }
        }
        return result;
    }

    private int partialCalculate(int num1, String operator, String num2) {
        return Operator.of(operator)
                .operate(num1, Digit.of(num2).getNum());
    }
}
