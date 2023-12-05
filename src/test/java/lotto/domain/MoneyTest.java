package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class MoneyTest {

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 100, 1000, Integer.MAX_VALUE})
    @DisplayName("양수로 Money를 만들면 양수를 가진 Money가 만들어진다.")
    void money_canHasPositive(int input) {
        Money money = new Money(input);
        assertThat(money.intValue()).isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(ints = { -1, -2, -100, -1000, Integer.MIN_VALUE})
    @DisplayName("음수로 Money를 만들면 예외를 발생시킨다.")
    void money_cannotHasNegative(int input) {
        assertThatThrownBy(() -> {
            new Money(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("돈은 음수 일수 없습니다.");
    }

}