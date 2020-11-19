package lotto.controller;

import lotto.domain.Round;
import lotto.service.ReportService;

public class ReportController {
    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    public void generate(Round round) {
        reportService.generate(round);
    }
}
