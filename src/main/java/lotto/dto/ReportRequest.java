package lotto.dto;

import lotto.domain.LottoTickets;

public class ReportRequest {

    private final LottoTickets lottoTickets;
    private final String winningLottoNumbers;

    public ReportRequest(final LottoTickets lottoTickets, final String winningLottoNumbers) {
        this.lottoTickets = lottoTickets;
        this.winningLottoNumbers = winningLottoNumbers;
    }

    public LottoTickets getLottoTickets() {
        return lottoTickets;
    }

    public String getWinningLottoNumbers() {
        return winningLottoNumbers;
    }
}
