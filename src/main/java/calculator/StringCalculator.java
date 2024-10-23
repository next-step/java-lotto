package calculator;

public class StringCalculator {

    private static final String DELIMITER = " ";
    private static final int FIRST_INDEX = 0;

    public int calculator(String input) {
        validationInput(input);

        String[] inputSplit = input.split(DELIMITER);
        int result = Integer.parseInt(inputSplit[FIRST_INDEX]);

        for (int i = 1; i < inputSplit.length; i += 2) {
            String operator = inputSplit[i];
            int number = Integer.parseInt(inputSplit[i + 1]);

            result = Operator.symbolToOperator(operator).apply(result, number);
        }
        return result;
    }

    private static void validationInput(String input) {
        if (input == null || input.trim().isBlank()) {
            throw new IllegalArgumentException("입력값이 null이거나 공백문자인 경우 계산되지 않습니다.");
        }
    }
}
