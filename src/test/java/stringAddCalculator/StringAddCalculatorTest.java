package stringAddCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class StringAddCalculatorTest {

    private StringAddCalculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new StringAddCalculator();
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void add_null_또는_빈문자(String param) {
        assertThat(calculator.add(param)).isEqualTo(0);
    }
}