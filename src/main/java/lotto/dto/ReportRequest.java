package lotto.dto;

import lotto.domain.LottoTickets;

public class ReportRequest {

    private final LottoTickets lottoTickets;
    private final WinningRequest winningRequest;

    public ReportRequest(final LottoTickets lottoTickets, final WinningRequest winningRequest) {
        this.lottoTickets = lottoTickets;
        this.winningRequest = winningRequest;
    }

    public LottoTickets getLottoTickets() {
        return lottoTickets;
    }

    public String getWinningNumbers() {
        return winningRequest.getWinningNumbers();
    }

    public String getBonusNumber() {
        return winningRequest.getBonusNumbers();
    }
}
