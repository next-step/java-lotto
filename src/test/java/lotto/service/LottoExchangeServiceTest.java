package lotto.service;

import lotto.domain.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoExchangeServiceTest {

    @Test
    @DisplayName("로또 교환기 생성 확인")
    void purchaseLottos() {
        // given
        Integer purchasePrice = 14000;

        // when
        LottoTickets lottoTickets = new LottoExchangeService().purchaseLottoTickets(purchasePrice);

        // then
        assertThat(lottoTickets).isEqualTo(new LottoTickets(14, purchasePrice));
    }
}
