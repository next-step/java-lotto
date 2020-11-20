package lotto.controller;

import lotto.domain.Round;
import lotto.service.LottoService;
import lotto.service.ReportService;
import lotto.service.RoundService;
import lotto.view.ResultView;

public class ReportController {
    private final ReportService reportService;
    private final RoundService roundService;
    private final LottoService lottoService;

    public ReportController(ReportService reportService, RoundService roundService, LottoService lottoService) {
        this.reportService = reportService;
        this.roundService = roundService;
        this.lottoService = lottoService;
    }

    public void generate(Round round) {
        reportService.generate(round);
    }

    public void reportView() {
        Round round = roundService.get();
        generate(round);
        ResultView.report(lottoService.getPrizeMap(), round.getReport());
    }
}
