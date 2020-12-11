package lotto.application;

import lotto.domain.LottoMachine;
import lotto.domain.LottoReport;
import lotto.domain.LottoTickets;
import lotto.domain.WinningLotto;
import lotto.dto.PurchaseResponse;
import lotto.dto.ReportRequest;
import lotto.dto.ReportResponse;

public class LottoService {

    private final LottoMachine lottoMachine;

    public LottoService(final LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public PurchaseResponse create(long amount) {
        LottoTickets lottoTickets = lottoMachine.automatic(amount);
        return PurchaseResponse.of(lottoTickets);
    }

    public ReportResponse report(final ReportRequest reportRequest) {
        WinningLotto winningLotto = lottoMachine.winning(
                reportRequest.getWinningNumbers(),
                reportRequest.getBonusNumber());
        LottoTickets lottoTickets = reportRequest.getLottoTickets();
        LottoReport report = LottoReport.of(lottoTickets.match(winningLotto));
        return ReportResponse.of(report);
    }
}
