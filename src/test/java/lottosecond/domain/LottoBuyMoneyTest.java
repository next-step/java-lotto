package lottosecond.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoBuyMoneyTest {

    @Test
    @DisplayName("구입 금액은 1000의 배수여야 합니다.")
    void illegalLottoBuyMoney() {
        // given
        // when
        // then
        assertThatThrownBy(() -> new LottoBuyMoney(1300))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 구매 금액은 1000의 배수여야 합니다.");
    }

    @Test
    @DisplayName("로또 구입 금액을 통해 총 몇 장의 로또를 샀는지 알려줍니다.")
    void countLotto() {
        // given
        LottoBuyMoney lottoBuyMoney = new LottoBuyMoney(13000);
        // when
        int result = lottoBuyMoney.countLotto();
        // then
        assertThat(result).isEqualTo(13);
    }
}