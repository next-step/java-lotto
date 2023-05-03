package domain;


public class StringCalculator {

    private static final String ERROR_INPUT_CANNOT_BE_EMPTY_OR_NULL = "입력값은 Null이나 빈 값이 될 수 없습니다.";
    private static final String ERROR_INPUT_LENGTH_CANNOT_BE_EVEN = "입력 연산의 총 갯수는 짝수일 수 없습니다.";
    private static final String DELIMITER_SPLIT_STRING = " ";

    public Number calculateString(String input) {
        validateInputValue(input);
        validateIsEvenLength(input);
        String[] separatedString = input.split(DELIMITER_SPLIT_STRING);
        return calculateEachNumber(separatedString);
    }

    private Number calculateEachNumber(String[] separatedString) {
        double result = Integer.parseInt(separatedString[0]);
        for (int i = 1; i < separatedString.length; i += 2) {
            Operator operator = Operator.find(separatedString[i].charAt(0));
            result = operator.calculate(result, Integer.parseInt(separatedString[i + 1])).value();
        }
        return new Number(result);
    }

    private void validateInputValue(String input) {
        if (isInputValueValid(input)) {
            throw new IllegalArgumentException(ERROR_INPUT_CANNOT_BE_EMPTY_OR_NULL);
        }
    }

    private boolean isInputValueValid(String input) {
        return input == null || input.isEmpty();
    }

    private void validateIsEvenLength(String input) {
        if (input.length() % 2 == 0) {
            throw new IllegalArgumentException(ERROR_INPUT_LENGTH_CANNOT_BE_EVEN);
        }
    }
}
