package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    void 빈_문자열_또는_null_값을_입력한_경우_0을_반환한다(String text) {
        assertThat(Calculator.sum(text)).isZero();
    }
}
