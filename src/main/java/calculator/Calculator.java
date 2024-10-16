package calculator;

import calculator.domain.Operation;
import calculator.service.OperationFactory;
import calculator.view.InputView;
import calculator.view.ResultView;

public class Calculator {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        ResultView.print(calculator.calculate(InputView.input()));
    }

    public int calculate(String input) {

        String[] split = validateData(input.split(" "));

        // 홀수는 -> 숫자 /// 짝수는 연산
        int num1 = validateInt(split[0]);

        for (int i = 1; i < split.length - 1; i += 2) {
            Operation operation = validateOperation(OperationFactory.getOperation(split[i]));

            try {
                num1 = operation.calculate(num1, validateInt(split[i + 1]));
            } catch (Exception e) {
                System.out.println(e);
                System.out.println(e.getMessage());
            }
        }

        return num1;
    }

    private String[] validateData(String[] split) {
        if (split.length % 2 == 0) {
            throw new IllegalArgumentException("유효하지 않은 연산");
        }

        return split;
    }

    private Operation validateOperation(Operation operation) {

        if (operation == null) {
            throw new IllegalArgumentException("유효하지 않은 연산");
        }

        return operation;
    }

    private static int validateInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바르지 않은 형식입니다: " + value);
        }
    }
}
