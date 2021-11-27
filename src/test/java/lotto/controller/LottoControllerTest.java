package lotto.controller;

import lotto.domain.LottoTicketGenerator;
import lotto.domain.value.LottoResult;
import lotto.domain.value.LottoTickets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.fixture.LottoTicketFixture.LOTTO_TICKETS;
import static lotto.fixture.LottoTicketFixture.PROFIT_RATE;
import static org.assertj.core.api.Assertions.assertThat;

class LottoControllerTest {

    private LottoController lottoController;

    @BeforeEach
    void setUp() {
        lottoController = new LottoController(new LottoTicketGenerator());
    }

    @DisplayName("금액에 맞는 로또티켓을 생성한다.")
    @Test
    void createLottoTickets() {
        // given
        String purchaseAmount = "14000";

        // when
        LottoTickets lottoTickets = lottoController.createLottoTickets(purchaseAmount);

        // then
        assertThat(lottoTickets.size()).isEqualTo(14);
    }

    @DisplayName("당첨결과를 반환한다.")
    @Test
    void createLottoResult() {
        // given
        String numbers = "1, 2, 3, 4, 5, 6";

        // when
        LottoResult lottoResult = lottoController.createLottoResult(numbers, LOTTO_TICKETS);

        // then
        assertThat(lottoResult.getProfitRate()).isEqualTo(PROFIT_RATE);
    }


}