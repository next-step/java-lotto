package lotto.domain.exception;

public class NotValidLottoPriceException extends RuntimeException {

    public NotValidLottoPriceException(String message){
        super(message);
    }
}
