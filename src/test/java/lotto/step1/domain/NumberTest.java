package lotto.step1.domain;

import lotto.step1.exception.StringAddCalculatorException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
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

    @DisplayName("of로 값을 생성후, final 상태값 일치하는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "5:5", "10:10"}, delimiter = ':')
    void number_상태값_테스트(int input, int expected) {
        Number number = Number.of(input);
        assertThat(number).isEqualTo(Number.of(expected));
    }
}
