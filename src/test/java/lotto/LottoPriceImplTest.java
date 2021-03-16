package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("로또금액")
class LottoPriceImplTest {
    LottoPrice lottoPrice = new LottoPriceImpl();
    @Test
    @DisplayName("하나에 천원")
    void pay() {
        Assertions.assertThat(lottoPrice.howManyPass(14000)).isEqualTo(14);
    }
}