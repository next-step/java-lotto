package dev.dahye.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Money 객체 테스트")
class LottoMoneyTest {
    @ParameterizedTest(name = "금액 = {0}")
    @ValueSource(ints = {100, 101, 222, 33333, 0, -1000})
    @DisplayName("돈은 1000원 단위가 아닌 경우 IllegalArgument Exception throw")
    void validate_money(int money) {
        assertThatThrownBy(() -> new LottoMoney(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또는 1000원 단위로 구입할 수 있습니다.");
    }
}