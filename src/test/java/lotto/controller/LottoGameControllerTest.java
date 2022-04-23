package lotto.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.domain.LottoResult;
import lotto.domain.LottoTickets;
import org.junit.jupiter.api.Test;

class LottoGameControllerTest {

    private LottoGameController lottoGame = new LottoGameController();

    @Test
    void createLottoTicketsTest() {
        LottoTickets lottoTickets = lottoGame.createLottoTickets(3000);

        assertThat(lottoTickets.count()).isEqualTo(3);
    }

    @Test
    void analysisTest() {
        LottoTickets lottoTickets = lottoGame.createLottoTickets(3000);

        List<LottoResult> lottoResults = lottoGame.analysisResult(lottoTickets, Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(lottoResults).hasSize(3);
    }

}