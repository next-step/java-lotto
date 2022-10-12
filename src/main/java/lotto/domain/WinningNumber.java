package lotto.domain;

public class WinningNumber {

    private final LottoTicket winningNumber;

    public WinningNumber(LottoTicket winningNumber) {
        if (winningNumber == null) {
            throw new IllegalArgumentException("당첨 번호를 전달 받지 못하였습니다.");
        }
        this.winningNumber = winningNumber;
    }

    public LottoTicket winningNumber() {
        return winningNumber;
    }
}
