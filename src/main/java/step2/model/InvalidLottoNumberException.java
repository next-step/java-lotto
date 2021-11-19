package step2.model;

public class InvalidLottoNumberException extends RuntimeException{

    private static final String ERROR_MESSAGE = "로또 번호는 1과 45 사이입니다";

    public InvalidLottoNumberException() {
        super(ERROR_MESSAGE);
    }
}
