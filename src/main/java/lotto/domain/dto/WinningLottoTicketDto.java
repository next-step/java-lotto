package lotto.domain.dto;

import lotto.domain.LottoTickets;

public class WinningLottoTicketDto {

    private final LottoTickets lottoTickets;
    private final WinningNumberDto winningNumberDto;

    public WinningLottoTicketDto(LottoTickets lottoTickets, WinningNumberDto winningNumberDto) {
        this.lottoTickets = lottoTickets;
        this.winningNumberDto = winningNumberDto;
    }

    public LottoTickets getLottoTickets() {
        return lottoTickets;
    }

    public String getWinningNumbers() {
        return winningNumberDto.getWinnerNumbers();
    }

    public int getBonusNumber() {
        return winningNumberDto.getBonusNumber();
    }

}
