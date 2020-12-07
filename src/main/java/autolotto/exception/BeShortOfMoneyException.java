package autolotto.exception;

public class BeShortOfMoneyException extends IllegalArgumentException {

    public BeShortOfMoneyException(String message){
        super(message);
    }
}
