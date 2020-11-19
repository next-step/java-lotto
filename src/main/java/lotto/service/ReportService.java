package lotto.service;

import lotto.domain.LottoReport;
import lotto.domain.Pick;
import lotto.domain.Round;

import java.util.Objects;

public class ReportService {
    private final LottoService lottoService;

    public ReportService(LottoService lottoService) {
        this.lottoService = lottoService;
    }


    public void generate(Round round) {
        LottoReport report = round.getReport();
        report.setCost((long) (lottoService.getPrice() * round.getMyPicks().size()));
        round.getMyPicks().stream()
                .map(Pick::getRank)
                .filter(Objects::nonNull)
                .map(lottoService::getPrize)
                .forEach(report::addPrize);
    }
}
