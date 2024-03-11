package calculator;

public class StringCalculator {

    public static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("null 또는 공백이 들어옴");
        }
        String[] operands = input.split(" ");
        Operator operator = Operator.from(operands[1]);
        int left = Integer.parseInt(operands[0]);
        int right = Integer.parseInt(operands[2]);

        return operator.compute(left, right);
    }
}
