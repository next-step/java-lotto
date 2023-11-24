package step2.domain;

public class LottoWinningTicket {
    private final LottoTicket winningTicket;
    private final LottoNumber bonusNumber;

    public LottoWinningTicket(LottoTicket winningTicket, LottoNumber bonusNumber) {
        this.winningTicket = winningTicket;
        this.bonusNumber = bonusNumber;
    }

    public LottoTicket winningTicket() {
        return winningTicket;
    }

    public LottoNumber bonusNumber() {
        return bonusNumber;
    }
}
