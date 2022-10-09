package lotto.domain;

public class CanNotBuyLottoException extends RuntimeException {

    public CanNotBuyLottoException(String message) {
        super(message);
    }
}
