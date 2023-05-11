package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

    @ParameterizedTest
    @ValueSource(strings = {"0", "100000"})
    @DisplayName("정상 금액 생성")
    void createSuccess(String input) {
        new Money(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "99999999"})
    @DisplayName("비정상 금액 생성")
    void createFail(String input) {
        Assertions.assertThatThrownBy(() -> new Money(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Invalid");
    }
}