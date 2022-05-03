package study.step1.domain;

public class Formula {
    private static final String EXCEPTION_MESSAGE = "올바른 수식을 입력해주세요.";
    private static final String REGULAR_EXPRESSION = "^[+\\-*/\\d]*$";
    private static final String SPACE = " ";
    private static final String EMPTY = "";
    private final String arithmeticOperation;

    private Formula(String formula) {
        this.arithmeticOperation = formula;
    }

    public static Formula from(String nextLine) {
        if (isInvalid(nextLine)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        return new Formula(nextLine);
    }

    private static boolean isInvalid(String nextLine) {
        return !nextLine.replaceAll(SPACE, EMPTY).matches(REGULAR_EXPRESSION);
    }

    public String getString() {
        return arithmeticOperation;
    }
}