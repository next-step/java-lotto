package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

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
        assertThatThrownBy(() -> new Money(value)).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "100,000"})
    @DisplayName("숫자가 아닌 문자열 입력 테스트")
    void money_notNumericInput(final String value) {
        /* given & when & then */
        assertThatThrownBy(() -> new Money(value)).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("돈 차감 테스트")
    void money_subtract() {
        // given
        final Money money1 = new Money("10000");
        final Money money2 = new Money("4000");

        // when
        final Money subtracted = money1.subtract(money2);

        // then
        assertEquals(6000, subtracted.getValue());
    }
}
