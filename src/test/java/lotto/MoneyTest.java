package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class MoneyTest {

    @Test
    @DisplayName("구매 금액 정상 생성 테스트")
    void money_test() {
        // given
        int money = 10000;

        // when
        Money lottoMoney = new Money(money);

        // then
        assertThat(lottoMoney).isEqualTo(new Money(money));

    }

    @Test
    @DisplayName("1000원 미만 금액 입력시 예외발생 테스트")
    void money_lack_exception_test() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            Money money = new Money(500);
        }).withMessageMatching("금액이 부족합니다. 로또를 구매할 수 없습니다.");
    }

}
