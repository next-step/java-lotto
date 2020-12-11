package lotto.application;

import lotto.domain.LottoMachine;
import lotto.domain.LottoReport;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.dto.PurchaseResponse;
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

    public ReportResponse report(LottoTickets lottoTickets, String winningNumbers) {
        LottoTicket winning = lottoMachine.manual(winningNumbers);
        LottoReport report = LottoReport.of(lottoTickets.match(winning));
        return ReportResponse.of(report);
    }
}
