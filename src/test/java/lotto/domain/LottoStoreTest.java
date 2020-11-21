package lotto.domain;

import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoTicketMockFactory;
import lotto.domain.lotto.LottoTicketGroup;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static lotto.domain.LottoStore.NOT_ENOUGH_MONEY_TO_BUY_LOTTO;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoStoreTest {
    @DisplayName("판매")
    @Nested
    class Sell {
        @DisplayName("자동 선택과 수동 선택을 혼합해서 판매")
        @Test
        void return_lottos_when_quick_pick_and_manual_buying() {
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

        @DisplayName("수동 선택으로 구매하기 원하는 로또가 지불한 돈보다 비싼 경우")
        @Test
        void throw_exception_when_lotto_price_is_more_expensive_then_payed_money() {
            // given
            final Money money = LottoTicket.getPrice();
            final LottoTicket lottoTicket1 = LottoTicketMockFactory.createLottoHasNumberOneToSix();
            final LottoTicket lottoTicket2 = LottoTicketMockFactory.createLottoHasNumberOneToSix();
            final LottoTicketGroup lottoTicketGroup = LottoTicketGroup.of(Arrays.asList(lottoTicket1, lottoTicket2));

            // when
            final Throwable thrown = catchThrowable(() -> {
                LottoStore.sell(money, lottoTicketGroup);
            });

            // then
            Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(NOT_ENOUGH_MONEY_TO_BUY_LOTTO);
        }
    }

}