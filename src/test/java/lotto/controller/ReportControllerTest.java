package lotto.controller;

import lotto.domain.LottoConstraint;
import lotto.domain.Pick;
import lotto.domain.Round;
import lotto.domain.enums.Rank;
import lotto.service.AutoPickService;
import lotto.service.LottoPrizePackager;
import lotto.service.LottoService;
import lotto.service.ReportService;
import lotto.service.RoundService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReportControllerTest {

    private Round round;
    private ReportController reportController;

    @BeforeEach
    void setup(){
        LottoService lottoService = new LottoService(1000, new LottoConstraint(6, 45), new LottoPrizePackager());
        RoundService roundService = new RoundService(new AutoPickService(lottoService), lottoService);
        round = roundService.autoBuy(100);
        roundService.checkWinning(round.getMyPicks().stream().map(Pick::getBalls).findFirst().get());
        reportController = new ReportController(new ReportService(lottoService), roundService, lottoService);
    }

    @Test
    void testGenerateReport(){
        reportController.generate(round);
        assertThat(round.getReport()).isNotNull();
        assertThat(round.getReport().getCost()).isEqualTo(1000 * 100);
        assertThat(round.getReport().getRankMap().get(Rank.FIRST)).isGreaterThanOrEqualTo(1);
    }
}
