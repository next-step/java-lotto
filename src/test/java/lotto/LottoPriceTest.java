package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또금액")
class LottoPriceTest {
    LottoPrice lottoPrice = new LottoPrice();
    @Test
    @DisplayName("하나에 천원")
    void pay() {
        assertThat(lottoPrice.lottos(14000))
                .isEqualTo(14);
    }
}
