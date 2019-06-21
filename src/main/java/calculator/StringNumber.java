package calculator;

public class StringNumber {

    private static final String NOT_A_NUMBER_EXCEPTION_MESSAGE = "숫자가 아닙니다.";;
    private static final String CANNOT_USE_NEGATIVE_NUMBER_EXCEPTION_MESSAGE = "음수는 넣을수 없습니다.";

    private final String stringNumber;

    public StringNumber(final String stringNumber) {
        this.stringNumber = stringNumber;
    }

    public int parse() {
        int result;
        try {
            result = Integer.valueOf(stringNumber);
        } catch (NumberFormatException e) {
            throw new RuntimeException(NOT_A_NUMBER_EXCEPTION_MESSAGE);
        }

        if (result < 0) throw new RuntimeException(CANNOT_USE_NEGATIVE_NUMBER_EXCEPTION_MESSAGE);
        return result;
    }
}
