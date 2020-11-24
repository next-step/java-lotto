package lotto.domain.exception;

public class NotValidLottoNumberException extends RuntimeException{

    public NotValidLottoNumberException(String message){
        super(message);
    }
}
