package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BuyLottoTest {

    @Test
    void buyMoneyLotto_test() {
        BuyLotto buyLotto = new BuyLotto(5000);
        assertThat(buyLotto.getLotto().size()).isEqualTo(5);
    }
}