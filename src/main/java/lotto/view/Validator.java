package lotto.view;

public abstract class Validator {

    protected static final String INPUT_NULL_MESSAGE = "null 값을 입력하였습니다!";

    protected static final String INPUT_EMPTY_MESSAGE = "빈 값을 입력하셨습니다!";

    protected static final String EMPTY = "";

    protected void validate(final String input) {
        checkNull(input);
        checkBlank(input);
    }

    protected void checkNull(final String input) {
        if (input == null) {
            throw new IllegalArgumentException(INPUT_NULL_MESSAGE);
        }
    }

    protected void checkBlank(final String input) {
        if (input.trim().equals(EMPTY)) {
            throw new IllegalArgumentException(INPUT_EMPTY_MESSAGE);
        }
    }
}
