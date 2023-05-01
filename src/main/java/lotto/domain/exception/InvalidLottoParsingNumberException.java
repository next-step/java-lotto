package lotto.domain.exception;

public class InvalidLottoParsingNumberException extends LottoException {
    private static final String NUMBER_FORMAT_ERROR_MESSAGE = "적절한 로또 숫자 문자열이 아닙니다.";

    public InvalidLottoParsingNumberException(Throwable throwable, String... message) {
        super(throwable, NUMBER_FORMAT_ERROR_MESSAGE, message);
    }
}
