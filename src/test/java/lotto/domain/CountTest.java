package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CountTest {

    @DisplayName("1 이상의 수를 입력하는 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1", "5", "10", "15"})
    void count_create(final String count) {
        assertDoesNotThrow(() -> new Count(count));
    }

    @DisplayName("0 이하의 수를 입력하는 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"-100", "-5", "-1", "0"})
    void count_notPositiveCount(final String count) {
        assertThrows(IllegalArgumentException.class, () -> new Count(count));
    }

    @DisplayName("수 이외의 문자를 입력하는 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1+2", "2-1", "1,000", "0.1"})
    void count_notNumericCount(final String count) {
        assertThrows(IllegalArgumentException.class, () -> new Count(count));
    }

    @DisplayName("구매 가능 금액 이상으로 수를 입력하는 테스트")
    @Test
    void count_notEnoughMoney() {
        Money money = new Money(0);

        assertThrows(IllegalArgumentException.class, () -> new Count("1", money));
    }
}
