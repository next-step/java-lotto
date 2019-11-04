package calc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringAddCalculatorTest {

    StringAddCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringAddCalculator();
    }

    @Test
    void 빈문자열_null_입력시_0을_반환테스트() {
        assertThat(calculator.add(null)).isEqualTo(0);
        assertThat(calculator.add("")).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4"})
    void 숫자_하나를_문자열로_입력하면_해당_숫자를_반환테스트(String input) {
        assertThat(calculator.add(input)).isEqualTo(Integer.parseInt(input));
    }
}
