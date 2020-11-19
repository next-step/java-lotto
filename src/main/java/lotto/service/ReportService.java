package lotto.service;

import lotto.domain.LottoReport;
import lotto.domain.Pick;
import lotto.domain.Round;
import lotto.domain.enums.Rank;
import lotto.message.ErrorMessage;

public class ReportService {
    private final LottoService lottoService;

    public ReportService(LottoService lottoService) {
        this.lottoService = lottoService;
    }


    public void generate(Round round) {
        LottoReport report = round.getReport();
        report.setCost((long) (lottoService.getPrice() * round.getMyPicks().size()));
        round.getMyPicks().stream().map(pick -> {
            validate(pick);
            Rank rank = pick.getRank();
            return lottoService.getPrize(rank);
        }).forEach(prize -> {
            report.addRanks(prize.getRank());
            report.addEarnings(prize.getCash());
        });
    }

    private void validate(Pick pick) {
        if(pick.getRank() == null){
            throw new RuntimeException(ErrorMessage.NEED_WINNING_CHECK_FIRST);
        }
    }
}
