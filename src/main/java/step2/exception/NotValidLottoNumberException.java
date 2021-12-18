package step2.exception;

public class NotValidLottoNumberException extends IllegalArgumentException {
    private static final String NOT_VALID_NUMBER = "로또 번호는 1 ~ 45 숫자만 가능합니다. 현재 들어온 값 : %d";

    public NotValidLottoNumberException(int input) {
        super(String.format(NOT_VALID_NUMBER, input));
    }
}
