package domain.Lotto;

public class WinningLotto {
    private final LottoTicket winningTicket;
    private final LottoNo bonusNumber;

    public WinningLotto(LottoTicket winningTicket, LottoNo bonusNumber) {
        this.winningTicket = winningTicket;
        this.bonusNumber = bonusNumber;
    }

    public LottoTicket getWinningTicket() {
        return winningTicket;
    }

    public LottoNo getBonusNumber() {
        return bonusNumber;
    }
}