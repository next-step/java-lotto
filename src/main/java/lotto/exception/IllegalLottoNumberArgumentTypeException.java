package lotto.exception;

public class IllegalLottoNumberArgumentTypeException extends NumberFormatException {
    public IllegalLottoNumberArgumentTypeException() {
        super("로또 번호는 숫자로만 요청할 수 있습니다.");
    }
}
