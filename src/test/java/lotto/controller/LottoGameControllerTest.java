package lotto.controller;

import static lotto.domain.LottoTicket.ONE_TICKET_PRICE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.domain.LottoResult;
import lotto.domain.LottoResults;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import org.junit.jupiter.api.Test;

class LottoGameControllerTest {

    private LottoGameController lottoGame = new LottoGameController();

    @Test
    void createLottoTicketsWithManualTest() {
        final int buyingMoney = 5000;
        LottoTickets manualLottoTickets = new LottoTickets(Arrays.asList(
            LottoTicket.create(1,2,3,4,5,6),
            LottoTicket.create(2,3,4,5,6,7),
            LottoTicket.create(3,4,5,6,7,8)
        ));

        LottoTickets lottoTickets = lottoGame.createLottoTicketsWithManual(buyingMoney, manualLottoTickets);

        assertThat(lottoTickets.size()).isEqualTo(buyingMoney / ONE_TICKET_PRICE);
    }

    @Test
    void createLottoTicketsTest() {
        final int buyingMoney = 5000;
        LottoTickets lottoTickets = lottoGame.createLottoTickets(buyingMoney);

        assertThat(lottoTickets.count()).isEqualTo(buyingMoney / ONE_TICKET_PRICE);
    }

    @Test
    void analysisTest() {
        final int buyingMoney = 5000;
        LottoTickets lottoTickets = lottoGame.createLottoTickets(buyingMoney);

        LottoResults lottoResults = lottoGame.analysisResult(lottoTickets, Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        assertThat(lottoResults.size()).isEqualTo(buyingMoney / ONE_TICKET_PRICE);
    }

}