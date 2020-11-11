package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoBuyerTest {
    @DisplayName("구매자가 로또를 구매")
    @Test
    void buy_lotto() {
        // given
        final Money money = Money.of(2000);
        final LottoBuyer lottoBuyer = LottoBuyer.of(money);
        final int lottoCount = 2;
        final LottoStore lottoStore = new LottoStore();

        // when
        lottoBuyer.buy(lottoStore);
        final Lottos lottos = lottoBuyer.getLottos();
        
        // then
        assertThat(lottos.size()).isEqualTo(lottoCount);
    }
}
