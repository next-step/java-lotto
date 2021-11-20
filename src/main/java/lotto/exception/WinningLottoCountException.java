package lotto.exception;

public class WinningLottoCountException extends RuntimeException {
    private static final String MESSAGE = "우승 번호 개수(%d 개)를 잘못 입력 했습니다.";

    public WinningLottoCountException(int count) {
        super(String.format(MESSAGE, count));
    }
}
