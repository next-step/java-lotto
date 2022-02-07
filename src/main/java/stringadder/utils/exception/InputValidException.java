package stringadder.utils.exception;

public class InputValidException {

    private static final String NEGATIVE_INPUT_ERROR = "음수는 입력할 수 없습니다!";

    public static void inputNegativeValidation(int input) {
        if (input < 0) {
            throw new IllegalArgumentException(NEGATIVE_INPUT_ERROR);
        }
    }
}
