package lotto.exception;

public class LottoNumbersCountException extends RuntimeException {
    private static final String MESSAGE = "로또 번호 개수(%d 개)를 잘못 입력 했습니다.";

    public LottoNumbersCountException(int count) {
        super(String.format(MESSAGE, count));
    }
}
