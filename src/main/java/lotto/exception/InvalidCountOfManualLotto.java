package lotto.exception;

public class InvalidCountOfManualLotto extends RuntimeException {
    private static final String MESSAGE = "총 개수 이내에서 수동 개수 입력 가능합니다(총: %s, 수동: %s).";

    public InvalidCountOfManualLotto(int total, int manual) {
        super(String.format(MESSAGE, total, manual));
    }
}
