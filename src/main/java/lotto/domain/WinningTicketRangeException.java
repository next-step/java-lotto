package lotto.domain;

public class WinningTicketRangeException extends IllegalArgumentException {
    public WinningTicketRangeException(String message) {
        super("당첨번호가 올바르지 않습니다. 원인: " + message);
    }
}
