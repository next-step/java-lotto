package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또금액")
class LottoPriceTest {
    LottoPrice lottoPrice = new LottoPrice();
    @Test
    @DisplayName("하나에 천원")
    void pay() {
        Assertions.assertThat(lottoPrice.lottos(14000)).isEqualTo(14);
    }
}
