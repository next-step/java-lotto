package domain.Lotto;

public class WinningLotto {
    private final LottoTicket winningTicket;
    private final int bonusNumber;

    public WinningLotto(LottoTicket winningTicket, int bonusNumber) {
        this.winningTicket = winningTicket;
        this.bonusNumber = bonusNumber;
    }

    public LottoTicket getWinningTicket() {
        return winningTicket;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}