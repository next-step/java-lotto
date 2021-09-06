package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPriceTest {
    @Test
    @DisplayName("구입 금액으로부터 구매할 수 있는 수량 계산 테스트")
    void getAvailableCount() {
        assertThat(LottoPrice.getAvailableCount(-1)).isEqualTo(0);
        assertThat(LottoPrice.getAvailableCount(0)).isEqualTo(0);
        assertThat(LottoPrice.getAvailableCount(1_800)).isEqualTo(1);
        assertThat(LottoPrice.getAvailableCount(10_000)).isEqualTo(10);
    }
}