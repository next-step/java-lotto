package lotto.domain;

import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoTicketMockFactory;
import lotto.domain.lotto.LottoTicketGroup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoStoreTest {
    @DisplayName("판매")
    @Nested
    class Sell {
        @DisplayName("자동 선택과 수동 선택을 혼합해서 판매")
        @Test
        void return_lottos_when_quick_pick_and_slip_buying() {
            // given
            final Money money = LottoTicket.getPrice().multiply(2);
            final LottoTicket lottoTicket = LottoTicketMockFactory.createLottoHasNumberOneToSix();
            final LottoTicketGroup lottoTicketGroup = LottoTicketGroup.of(Collections.singletonList(lottoTicket));

            // when
            final LottoTicketGroup result = LottoStore.sell(money, lottoTicketGroup);

            // then
            assertThat(result).isNotNull();
            assertThat(result.size()).isEqualTo(2);
        }

        @DisplayName("자동으로만 판매")
        @Test
        void return_lottos_when_only_quick_pick() {
            // given
            final Money money = LottoTicket.getPrice();
            
            // when
            final LottoTicketGroup lottoTicketGroup = LottoStore.sell(money, null);

            // then
            assertThat(lottoTicketGroup).isNotNull();
            assertThat(lottoTicketGroup.size()).isOne();
        }

        @DisplayName("빈 lottos 반환")
        @Test
        void return_empty_lottos_when_money_null() {
            // when
            final LottoTicketGroup lottoTicketGroup = LottoStore.sell(null, null);

            // then
            assertThat(lottoTicketGroup).isNotNull();
            assertThat(lottoTicketGroup).isEqualTo(LottoTicketGroup.EMPTY);
        }
    }

}