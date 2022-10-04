package calculator;

import java.util.List;

public class StringCalculator {

    private StringCalculator() { }

    public static List<String> getOperations(String text) {
        if(text == null || text.isBlank()) {
            throw new IllegalArgumentException("입력값을 입력해주세요.");
        }

        return List.of(text.split(" "));
    }

    public static int calculate(List<String> operations) {
        int leftOperand = Integer.parseInt(operations.get(0));
        int rightOperand;

        for (int i = 2; i < operations.size(); i += 2) {
            Operator operator = Operator.of(operations.get(i - 1));
            rightOperand = Integer.parseInt(operations.get(i));
            leftOperand = operator.calculate(leftOperand, rightOperand);
        }

        return leftOperand;
    }

}
