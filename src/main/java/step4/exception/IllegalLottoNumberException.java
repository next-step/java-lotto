package step4.exception;

public class IllegalLottoNumberException extends RuntimeException{

    public IllegalLottoNumberException() {
        super();
    }

    public IllegalLottoNumberException(String message) {
        super(message);
    }
}
