package lotto.domain;

import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoStoreTest {

    @DisplayName("판매")
    @Nested
    class Sell {
        @DisplayName("정상")
        @Test
        void return_lottos() {
            // given
            final Money money = LottoTicket.getPrice();

            // when
            final LottoTickets lottoTickets = LottoStore.sell(money);

            // then
            assertThat(lottoTickets).isNotNull();
            assertThat(lottoTickets.size()).isOne();
        }

        @DisplayName("빈 lottos 반환")
        @Test
        void return_empty_lottos() {
            // when
            final LottoTickets lottoTickets = LottoStore.sell(null);

            // then
            assertThat(lottoTickets).isNotNull();
            assertThat(lottoTickets).isEqualTo(LottoTickets.EMPTY);
        }
    }

}