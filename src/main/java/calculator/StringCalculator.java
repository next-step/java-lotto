package calculator;

import java.util.List;
import java.util.Objects;
import java.util.function.IntBinaryOperator;
import java.util.regex.Pattern;

public final class StringCalculator {

    public static final String DELIMITER = " ";
    private static final List<String> OPERATIONS = List.of("+", "-", "*", "/");
    private static final String FORMULA_PATTERN = "^(\\d+[ ][-+*/][ ])+\\d+$";

    private StringCalculator() {
    }

    public static int operate(String input) {

        validateInput(input);

        String[] tokens = input.split(DELIMITER);

        return calculateNumbers(tokens);
    }

    private static void validateInput(String input){
        validateEmptyInput(input);
        validateFormula(input);
    }

    private static void validateFormula(String input) {
        if(!Pattern.matches(FORMULA_PATTERN, input)){
            throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
        }
    }

    private static void validateEmptyInput(String input) {
        if (Objects.isNull(input) || input.trim().isEmpty()) {
            throw new IllegalArgumentException("null이나 빈 값은 입력할 수 없습니다.");
        }
    }

    private static int calculateNumbers(String[] tokens) {

        int result = Integer.parseInt(tokens[0]);

        for (int i = 0; i < tokens.length - 2; i += 2) {
            Operator operator = OperatorFactory.getInstance(tokens[i + 1]);
            IntBinaryOperator operate = operator.operate();
            result = operate.applyAsInt(result, Integer.parseInt(tokens[i + 2]));
        }

        return result;
    }
}
