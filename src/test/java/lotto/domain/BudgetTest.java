package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BudgetTest {

    @DisplayName("숫자만으로 이루어짐")
    @Test
    void 생성_숫자만으로_이루어짐() {
        // given
        String input = "14000";

        // then
        Assertions.assertDoesNotThrow(() -> new Budget(input));
    }

    @DisplayName("문자가 들어간 경우")
    @ValueSource(strings = {"1400 0", "aaa", "12a", "12 a"})
    @ParameterizedTest
    void 생성_숫자만으로_이루어짐(String input) {
        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Budget(input));
    }
}
