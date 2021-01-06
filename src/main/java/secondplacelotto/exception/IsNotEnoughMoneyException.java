package secondplacelotto.exception;

public class IsNotEnoughMoneyException extends IllegalArgumentException {

    public IsNotEnoughMoneyException(String message) {
        super(message);
    }
}
