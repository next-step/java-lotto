package lotto.domain.rank;

public class WinningLottoRangeException extends IllegalArgumentException {
    public WinningLottoRangeException(String message) {
        super("당첨번호가 올바르지 않습니다. 원인: " + message);
    }
}
