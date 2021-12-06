package step2.exception;

public class NotValidLottoNumber extends IllegalArgumentException {
    private static final String NOT_VALID_NUMBER = "로또 번호는 1 ~ 45 숫자만 가능합니다.";

    public NotValidLottoNumber() {
        super(NOT_VALID_NUMBER);
    }
}
