package lotto.ui;

import lotto.application.LottoService;
import lotto.dto.PurchaseRequest;
import lotto.dto.PurchaseResponse;
import lotto.dto.ReportRequest;
import lotto.dto.ReportResponse;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(final LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public PurchaseResponse purchase(PurchaseRequest request) {
        return lottoService.create(request.getAmount());
    }

    public ReportResponse report(ReportRequest reportRequest) {
        return lottoService.report(reportRequest.getLottoTickets(), reportRequest.getWinningLottoNumbers());
    }
}
