package step2.domain;

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
            final Money money = Lotto.getPrice();

            // when
            final Lottos lottos = LottoStore.sell(money);

            // then
            assertThat(lottos).isNotNull();
            assertThat(lottos.size()).isOne();
        }

        @DisplayName("빈 lottos 반환")
        @Test
        void return_empty_lottos() {
            // when
            final Lottos lottos = LottoStore.sell(null);

            // then
            assertThat(lottos).isNotNull();
            assertThat(lottos).isEqualTo(Lottos.EMPTY);
        }
    }

}