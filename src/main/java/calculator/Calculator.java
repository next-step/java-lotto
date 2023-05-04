package calculator;

public class Calculator {

    public static final String NUMBER_PATTERN = "[0-9]";
    public static final String OPERATOR_PATTERN = "[+\\-*/]";

    public static int calculate(String input) {
        validate(input);

        input = input.replace(" ", "");

        String[] operators = input.split(NUMBER_PATTERN);
        String[] numbers = input.split(OPERATOR_PATTERN);

        int result = Integer.parseInt(numbers[0]);

        for (int i = 1; i < operators.length; i++) {
            Operator operator = Operator.findOperator(operators[i]);
            result = operator.calculate(result, Integer.parseInt(numbers[i]));
        }

        return result;
    }

    public static void validate(String input) {
        if (input == null || "".equals(input.trim())) {
            throw new IllegalArgumentException("올바르지 않은 입력값 잆니다.");
        }

    }
}
