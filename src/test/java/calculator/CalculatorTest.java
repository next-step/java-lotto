package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    void 빈_문자열_또는_null_값을_입력한_경우_0을_반환한다(String text) {
        assertThat(Calculator.sum(text)).isZero();
    }

    @ParameterizedTest
    @ValueSource(strings = {"11", "1", "0"})
    void 숫자_하나를_문자열로_입력한_경우_해당_숫자를_반환한다(String text) {
        int value = Integer.parseInt(text);
        assertThat(Calculator.sum(text)).isEqualTo(value);
    }

}
