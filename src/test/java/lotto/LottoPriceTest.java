package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPriceTest {
    @Test
    @DisplayName("구입 금액으로부터 구매할 수 있는 수량 계산 테스트")
    void getAvailableCount() {
        LottoPrice lottoPrice = new LottoPrice();
        assertThat(lottoPrice.getAvailableCount(-1)).isEqualTo(0);
        assertThat(lottoPrice.getAvailableCount(0)).isEqualTo(0);
        assertThat(lottoPrice.getAvailableCount(1_800)).isEqualTo(1);
        assertThat(lottoPrice.getAvailableCount(10_000)).isEqualTo(10);
    }
}