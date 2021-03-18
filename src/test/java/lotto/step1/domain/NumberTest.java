package lotto.step1.domain;

import lotto.step1.exception.StringAddCalculatorException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {

    @DisplayName("음수일 경우 StringAddCalculatorException 발생")
    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3})
    void 음수값_테스트(int number) {
        assertThatThrownBy(() -> {
            Number.of(number);
        }).isInstanceOf(StringAddCalculatorException.class)
                .hasMessage("음수값은 올 수 없습니다.");
    }
}