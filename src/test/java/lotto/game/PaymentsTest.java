package lotto.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 구입 금액은")
class PaymentsTest {

    @DisplayName("양의 정수를 넣을 경우 정상적으로 초기화된다. ")
    @Test
    void mustBeMultipleOf1000() {
        assertThat(new Payments(5000)).isEqualTo(new Payments(5000));
    }

    @DisplayName("양의 정수이다.")
    @ParameterizedTest(name = "인풋 {0}에 대해 예외 던짐")
    @ValueSource(ints = {-1000, 0})
    void isPositiveInteger(int payments) {
        assertThatThrownBy(() -> new Payments(payments)).isInstanceOf(IllegalArgumentException.class).hasMessageMatching("구매 금액은 양수입니다.");
    }
}
