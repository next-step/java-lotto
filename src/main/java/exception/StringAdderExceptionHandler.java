package exception;

public final class StringAdderExceptionHandler {
    private static final String INPUT_NEGATIVE_VALUE = "음수는 입력할 수 없습니다.";

    private StringAdderExceptionHandler() { }

    public static void validate(int inputNumber) {
        if (inputNumber < 0) {
            throw new RuntimeException(INPUT_NEGATIVE_VALUE);
        }
    }
}
