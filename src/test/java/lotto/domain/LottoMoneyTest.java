package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoMoneyTest {

    @DisplayName("구매 금액을 전달하면 객체를 생성한다.")
    @Test
    void moneyTest() {
        int money = 1000;
        LottoMoney newMoney = new LottoMoney(money);

        assertThat(newMoney.getMoney()).isEqualTo(money);
    }

    @DisplayName("1000원 이하의 금액을 전달하면 IllegalArgumentException을 던진다.")
    @Test
    void moneyExceptionTest() {
        assertThatThrownBy(() -> new LottoMoney(100))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액을 전달하면 구매 개수를 가져올 수 있다.")
    @Test
    void countTest() {
        LottoMoney money = new LottoMoney(10000);

        assertThat(money.lottoCount()).isEqualTo(10);
    }
}
