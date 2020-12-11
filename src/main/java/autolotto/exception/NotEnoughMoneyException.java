package autolotto.exception;

public class NotEnoughMoneyException extends IllegalArgumentException {

    public NotEnoughMoneyException(String message){
        super(message);
    }
}
