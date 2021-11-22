package lotto.domain.dto;

import lotto.domain.LottoTickets;

public class WinningLottoTicketDto {

    private final LottoTickets lottoTickets;
    private final String winnerLottoTicket;

    public WinningLottoTicketDto(LottoTickets lottoTickets, String winnerLottoTicket) {
        this.lottoTickets = lottoTickets;
        this.winnerLottoTicket = winnerLottoTicket;
    }

    public LottoTickets getLottoTickets() {
        return lottoTickets;
    }

    public String getWinnerLottoTicket() {
        return winnerLottoTicket;
    }

}
