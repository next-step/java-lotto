package lotto.money;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("돈 클래스 테스트")
class MoneyTest {

    @DisplayName("돈은 숫자를 가지고 초기화 한다.")
    @ValueSource(ints = {0, 10, 100})
    @ParameterizedTest
    void initMoney(int monet) {
        assertThat(Money.init(monet)).isInstanceOf(Money.class);
    }

    @DisplayName("초기화 하는 돈이 0 미만일 경우 예외를 발생시킨다.")
    @ValueSource(ints = {-1, -5})
    @ParameterizedTest
    void initMoneyException(int money) {
        assertThatThrownBy(() -> Money.init(money)).isInstanceOf(IllegalArgumentException.class);
    }

}
