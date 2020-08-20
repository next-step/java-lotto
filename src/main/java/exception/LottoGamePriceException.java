package exception;

public class LottoGamePriceException extends RuntimeException {
    public LottoGamePriceException() {
        super();
    }

    public LottoGamePriceException(String message) {
        super(message);
    }
}
