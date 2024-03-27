package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoShopTest {

    @ParameterizedTest
    @ValueSource(ints = {1000, 5000, 10000})
    @DisplayName("지출한 금액 만큼의 로또 티켓을 구매한다.")
    void buyLotto(int money) {
        LottoShop lottoShop = new LottoShop();

        assertThat(lottoShop.buyLotto(money)).hasSize(money / lottoShop.getLottoPrice());
    }

    @Test
    @DisplayName("1000원 이하의 금액이면 IllegalArgumentException 발생한다.")
    void exception() {
        LottoShop lottoShop = new LottoShop();

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> lottoShop.buyLotto(999));
    }
}
