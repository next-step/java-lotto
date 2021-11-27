package lotto.controller;

import lotto.domain.LottoTicketGenerator;
import lotto.domain.value.LottoTickets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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


}