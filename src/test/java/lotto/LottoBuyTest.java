package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoBuyTest {
    @DisplayName("구매 금액 만큼 로또 구매 ( 가격은 1000원에 한장 )")
    @Test
    void countBuyLotto_구매_로또_갯수_검증_테스트() {
        LottoBuy lottoBuy = new LottoBuy();
        Lottos lottos = lottoBuy.buyLotto(14000);
        assertThat(lottos.isCount(14)).isTrue();
    }
}
