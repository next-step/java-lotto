package lotto.money;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("돈 클래스 테스트")
class MoneyTest {

    @DisplayName("돈은 숫자를 가지고 초기화 한다.")
    @ValueSource(ints = {0, 10, 100})
    @ParameterizedTest
    void initMoney(int payment) {
        assertThat(Money.init(payment)).isInstanceOf(Money.class);
    }
}
