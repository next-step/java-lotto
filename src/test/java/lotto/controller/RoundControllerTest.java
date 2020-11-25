package lotto.controller;

import lotto.domain.LottoConstraint;
import lotto.domain.Pick;
import lotto.domain.Round;
import lotto.domain.enums.Rank;
import lotto.service.AutoPickService;
import lotto.service.LottoPrizePackager;
import lotto.service.LottoService;
import lotto.service.RoundService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RoundControllerTest {
    private RoundController roundController;

    @BeforeEach
    void setup(){
        LottoService lottoService = new LottoService(1000, new LottoConstraint(6, 45), new LottoPrizePackager());
        RoundService roundService = new RoundService(new AutoPickService(lottoService), lottoService);
        roundController = new RoundController(roundService, lottoService);
    }

    @Test
    void testBuy(){
        Round round = roundController.autoBuy(14000L);

        assertThat(round).isNotNull();
        assertThat(round.getMyPicks()).hasSize(14);
    }
}
