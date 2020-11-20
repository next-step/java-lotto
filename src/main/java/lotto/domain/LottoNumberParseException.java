package lotto.domain;

public class LottoNumberParseException extends RuntimeException{

    public LottoNumberParseException(String message) {
        super(message);
    }

    public LottoNumberParseException(String message, Throwable cause) {
        super(message, cause);
    }
}
