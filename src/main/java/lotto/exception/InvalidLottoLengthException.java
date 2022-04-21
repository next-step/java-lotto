package lotto.exception;

public class InvalidLottoLengthException extends RuntimeException {
    private static final String MESSGAE = "유효한 로또 숫자는 6개입니다(현재길이: %s).";

    public InvalidLottoLengthException(int length) {
        super(String.format(MESSGAE, length));
    }
}
