package lotto.view;

public class InvalidWinningNumberException extends IllegalArgumentException {
    public InvalidWinningNumberException(String message) {
        super("당첨번호가 올바르지 않습니다. 원인: " + message);
    }
}
