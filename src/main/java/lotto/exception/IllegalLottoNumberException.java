package lotto.exception;

public class IllegalLottoNumberException extends RuntimeException {
    public IllegalLottoNumberException(int number) {
        super("로또 번호는 1보다 크거나 같고 45보다 작거나 같아야 합니다.===" + number);
    }
}
