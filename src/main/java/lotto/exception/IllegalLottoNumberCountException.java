package lotto.exception;

public class IllegalLottoNumberCountException extends RuntimeException {
    public IllegalLottoNumberCountException(int number) {
        super("로또 번호는 6개를 입력해야 합니다. ===" + number);
    }
}
