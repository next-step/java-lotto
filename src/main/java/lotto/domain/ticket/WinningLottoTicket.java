package lotto.domain.ticket;

public class WinningLottoTicket {

    private final LottoTicket ticket;

    private WinningLottoTicket(final LottoTicket ticket) {
        this.ticket = ticket;
    }
    public static WinningLottoTicket of(final String winningNumbers) {
        return new WinningLottoTicket(LottoTicket.of(winningNumbers));
    }
}
