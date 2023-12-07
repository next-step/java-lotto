package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoBuyInfoTest {

    @DisplayName("구매 금액과 수동으로 구매할 로또 수를 전달하면 객체를 생성한다.")
    @Test
    void moneyTest() {
        int money = 10000;
        int manualCount = 3;
        LottoBuyInfo buyInfo = new LottoBuyInfo(money, manualCount);

        assertThat(buyInfo.getMoney()).isEqualTo(money);
    }

    @DisplayName("1000원 이하의 금액을 전달하면 IllegalArgumentException을 던진다.")
    @Test
    void moneyExceptionTest() {
        assertThatThrownBy(() -> new LottoBuyInfo(100, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액과 수동으로 구매할 로또를 전달하면 자동으로 구매 할 개수를 가져올 수 있다.")
    @Test
    void countTest() {
        LottoBuyInfo buyInfo = new LottoBuyInfo(10000, 5);

        assertThat(buyInfo.getAutoCount()).isEqualTo(5);
    }
}
