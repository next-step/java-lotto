package lotto.domain;

public class NotValidLottoNumberException extends RuntimeException{

    public NotValidLottoNumberException(String message){
        super(message);
    }
}
