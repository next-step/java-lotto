package step2.exception;

public class IllegalLottoNumberException extends RuntimeException {
    public IllegalLottoNumberException(int number) {
        super(number + "는 로또 번호가 아닙니다.");
    }
}
