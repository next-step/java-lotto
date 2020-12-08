package lotto.domain.validator;

public class Validator {

    static final String INPUT_NULL_MESSAGE = "null 값을 입력하였습니다!";

    static final String INPUT_EMPTY_MESSAGE = "빈 값을 입력하셨습니다!";

    static final String EMPTY = "";

    public void validate(final String input) {
        checkNull(input);
        checkBlank(input);
    }

    private void checkNull(final String input) {
        if (input == null) {
            throw new IllegalArgumentException(INPUT_NULL_MESSAGE);
        }
    }

    private void checkBlank(final String input) {
        if (input.trim().equals(EMPTY)) {
            throw new IllegalArgumentException(INPUT_EMPTY_MESSAGE);
        }
    }
}
