package lotto.domain.dto;

import lotto.domain.LottoTickets;

public class WinningLottoTicketDto {

    private final LottoTickets lottoTickets;
    private final WinnerNumberDto winnerNumberDto;

    public WinningLottoTicketDto(LottoTickets lottoTickets, WinnerNumberDto winnerNumberDto) {
        this.lottoTickets = lottoTickets;
        this.winnerNumberDto = winnerNumberDto;
    }

    public LottoTickets getLottoTickets() {
        return lottoTickets;
    }

    public String getWinnerNumber() {
        return winnerNumberDto.getWinnerNumbers();
    }

    public int getBonusNumber() {
        return winnerNumberDto.getBonusNumber();
    }

}
