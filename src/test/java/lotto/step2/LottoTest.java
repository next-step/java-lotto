package lotto.step2;


import lotto.step2.domain.Lotto;
import lotto.step2.domain.LottoShop;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class LottoTest {

    @Test
    @DisplayName("로또 구입 금액에 맞는 로또 개수")
    void buyLotto() {
        int price = 5000;
        LottoShop lottoShop = new LottoShop(price);
        assertThat(lottoShop.sellLotto().getLotto().size()).isEqualTo(5);
    }
}

