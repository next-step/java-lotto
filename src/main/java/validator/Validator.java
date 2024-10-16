package validator;

public class Validator {
    private static final String operationsPattern = "^[\\d+\\-*/\\s]+";
    private static final String spacesPattern = "\\d+([ ]+[^\\w\\s][ ]+\\d+)*";

    private Validator() {
    }

    public static void isValidInput(String calculateString) {
        validateEmpty(calculateString);
        validateArithmeticOperations(calculateString);
        validateSpaces(calculateString);
    }

    private static void validateEmpty(String calculateString) {
        if (calculateString.isEmpty()) {
            throw new IllegalArgumentException("입력은 비어있을 수 없습니다.");
        }
    }

    private static void validateArithmeticOperations(String calculateString) {
        if (!calculateString.matches(operationsPattern)) {
            throw new IllegalArgumentException("입력은 숫자와 사칙연산 기호로만 이루어질 수 있습니다");
        }
    }

    private static void validateSpaces(String calculateString) {
        if (!calculateString.matches(spacesPattern)) {
            throw new IllegalArgumentException("숫자와 사칙연산 기호 사이에는 반드시 하나의 공백이 포함되어야 합니다.");
        }
    }
}
