package lotto.model;

public class WinningIdentifier {

    private LottoTicket winningTicket;

    public WinningIdentifier(LottoTicket winningTicket) {
        this.winningTicket = winningTicket;
    }

    public Rank checkWinning(LottoTicket lottoTicket) {
        return Rank.of(lottoTicket.compareTicket(winningTicket));
    }
}
