package stringAddCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

    @Test
    public void add_쉼표구분자() {
        assertThat(calculator.add("1,2")).isEqualTo(3);
    }

    @Test
    public void add_쉼표_또는_콜론_구분자() {
        assertThat(calculator.add("1,2:3")).isEqualTo(6);
    }

}