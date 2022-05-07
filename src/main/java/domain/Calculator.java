package domain;

import java.util.List;

public class Calculator {

    Operation operation = new FourArithmeticOperation();

    private static final int FIRST_OPERAND = 0;
    private static final int FIRST_OPERATOR = 0;
    private static final int SECOND_OPERAND = 1;

    public int operate(List<String> numbers, List<String> signs) {
        int result = operation.calculateFourArithmeticOperation(
                signs.get(FIRST_OPERATOR),
                Integer.parseInt(numbers.get(FIRST_OPERAND)),
                Integer.parseInt(numbers.get(SECOND_OPERAND)));

        for (int i = 1; i < signs.size(); i++) {
            result = operation.calculateFourArithmeticOperation(
                    signs.get(i),
                    result,
                    Integer.parseInt(numbers.get(i+1)));
        }
        return result;
    }
}
