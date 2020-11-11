package step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static step2.LottoBuyer.MONEY_MUST_NOT_BE_NULL;

public class LottoBuyerTest {
    @DisplayName("구매자가 로또를 구매")
    @Test
    void buy_lotto() {
        // given
        final Money money = Money.of(2000);
        final LottoBuyer lottoBuyer = LottoBuyer.of(money);
        final LottoStore lottoStore = new LottoStore();

        // when
        lottoBuyer.buy(lottoStore);

        // then
        final Lottos lottos = lottoBuyer.getLottos();
        assertThat(lottos.size()).isEqualTo(2);
    }

    @DisplayName("생성")
    @Nested
    class create {
        @DisplayName("실패")
        @Test
        void fail_when_receive_null() {
            // when
            final Throwable thrown = catchThrowable(() -> {
                LottoBuyer.of(null);
            });

            // then
            Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(MONEY_MUST_NOT_BE_NULL);
        }

        @DisplayName("성공")
        @Test
        void success() {
            // given
            final Money money = Money.of(1000);

            // when
            final LottoBuyer lottoBuyer = LottoBuyer.of(money);

            // then
            assertThat(lottoBuyer).isNotNull();
        }
    }
    
    @DisplayName("로또 조회 요청시 null을 반환하지 않는다.")
    @Test
    void getLottos_not_return_null() {
        // given
        final Money money = Money.of(1000);
        final LottoBuyer lottoBuyer = LottoBuyer.of(money);
        
        // when
        final Lottos lottos = lottoBuyer.getLottos();
        
        // then
        assertThat(lottos).isNotNull();
        assertThat(lottos.size()).isZero();
    }
}
