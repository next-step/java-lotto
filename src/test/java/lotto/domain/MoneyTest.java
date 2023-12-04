package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, -2 , -3, Integer.MIN_VALUE})
    @DisplayName("음수로 Money를 만들면 IllegalArgumentException 예외를 발생시킨다.")
    void negative_throwException(int input) {
        assertThatThrownBy(() -> {
            new Money(input);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("돈은 음수 일수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 30000, 40000, Integer.MAX_VALUE})
    @DisplayName("유효한 금액으로 만들어진 Money는 금액을 보장한다.")
    void rightValue_makeMoney(int number) {
        assertThat(new Money(number).intValue()).isEqualTo(number);
    }
}
