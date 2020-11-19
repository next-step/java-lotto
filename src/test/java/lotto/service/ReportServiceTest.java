package lotto.service;

import lotto.domain.LottoConstraint;
import lotto.domain.Round;
import lotto.domain.enums.Rank;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ReportServiceTest {
    @Test
    void testGenerateReport(){
        LottoService lottoService = new LottoService(1000, new LottoConstraint(6, 45), new DefaultPrizePackager());
        AutoPickService autoPickService = new AutoPickService(lottoService);
        RoundService roundService = new RoundService(autoPickService, lottoService);

        Round round = roundService.autoBuy(14);
        roundService.checkWinning(Arrays.asList(1,2,3,4,5,6));

        ReportService reportService = new ReportService(lottoService);
        reportService.generate(round);

        assertThat(round.getReport()).isNotNull();
        assertThat(round.getReport().getCost()).isNotNull();
        assertThat(round.getReport().getTotalEarnings()).isEqualTo(0L);
        assertThat(round.getReport().getRankMap()).extractingByKey(Rank.LOSE).isEqualTo(14);
    }
}
