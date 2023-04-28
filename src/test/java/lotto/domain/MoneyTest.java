package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @ParameterizedTest(name = "[{index}] {0}원 투입")
    @ValueSource(ints = {1000, 5000, 18000, 330000})
    void 구입금액입력(int inputMoney) {
        Money money = new Money(inputMoney);
        assertThat(money.getAmount()).isEqualTo(inputMoney);
    }

    @ParameterizedTest(name = "[{index}] {0}원 투입")
    @ValueSource(ints = {-1, -500, -3000, -15000})
    void 구입금액0미만입력(int inputMoney) {
        assertThatThrownBy(() -> new Money(inputMoney)).isInstanceOf(IllegalArgumentException.class);
    }
}