package sequenceCalculator;

public class ExpressionChecker {

    private static final String DIGIT_REGEX ="\\d+";
    private static final String BASIC_OPERATION_REGEX ="[+\\-*/]";

    public static boolean isDigit(String input) {
        return input.matches(DIGIT_REGEX);
    }

    public static boolean isBasicOperation(String input) {
        if(!input.matches(BASIC_OPERATION_REGEX)){
            throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
        }
        return true;
    }

}
