package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {

    @ParameterizedTest
    @ValueSource(strings = {"99999", "1000", "1001", "100000"})
    @DisplayName("구입 금액 정상 생성 입력 테스트")
    void money_inputValidMoney(final String value) {
        /* given & when & then */
        assertDoesNotThrow(() -> new Money(value));
    }

    @ParameterizedTest
    @ValueSource(strings = {"999", "100001"})
    @DisplayName("범위 초과 구입 금액 생성 테스트")
    void money_inputOutOfRangeMoney(final String value) {
        /* given & when & then */
        assertThatThrownBy(() -> new Money(value)).isExactlyInstanceOf(
                IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "100,000"})
    @DisplayName("숫자가 아닌 문자열 입력 테스트")
    void money_notNumericInput(final String value) {
        /* given & when & then */
        assertThatThrownBy(() -> new Money(value)).isExactlyInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    @DisplayName("금액에서 원하는 금액을 뺄 수 있는지 테스트")
    void money_minus() {
        Money money = new Money("10000");
        final Money receiveMoney = money.minus(new Money("7000"));

        assertThat(receiveMoney.getValue()).isEqualTo(3000);
    }

    @Test
    @DisplayName("현재 금액에서 초과한 금액을 빼는 경우 테스트")
    void money_minusWithException() {
        Money money = new Money("6000");

        assertThatThrownBy(() -> money.minus(new Money("7000")))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
