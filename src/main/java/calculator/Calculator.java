package calculator;

import calculator.domain.Operation;
import calculator.domain.OperationFactory;
import calculator.view.InputView;
import calculator.view.ResultView;

public class Calculator {
    private static final String DELIMITER = " ";

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        ResultView.print(calculator.calculate(InputView.input()));
    }

    public int calculate(String input) throws IllegalArgumentException {

        String[] split = validateData(input.split(DELIMITER));

        int num1 = getFirstOperand(split[0]);

        for (int i = 1; i < split.length - 1; i += 2) {
            Operation operation = OperationFactory.getOperation(split[i]);

            num1 = operation.calculate(num1, getFirstOperand(split[i + 1]));

        }

        return num1;
    }

    private String[] validateData(String[] split) {
        if (split.length % 2 == 0) {
            throw new IllegalArgumentException("유효하지 않은 연산");
        }

        return split;
    }


    private int getFirstOperand(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바르지 않은 형식입니다: " + value);
        }
    }
}
