package calculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorTest {
    private static StringAddCalculator stringAddCalculator;

    @BeforeAll
    static void setUp(){
        stringAddCalculator = new StringAddCalculator();
    }

    @Test
    void calculate_null_또는_빈문자() {
        int result = stringAddCalculator.calculate(null);
        assertThat(result).isEqualTo(0);

        result = stringAddCalculator.calculate("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    void calculate_숫자하나() {
        int result = stringAddCalculator.calculate("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void calculate_쉼표구분자() {
        int result = stringAddCalculator.calculate("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void calculate_쉼표_또는_콜론_구분자() {
        int result = stringAddCalculator.calculate("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void calculate_custom_구분자() {
        int result = stringAddCalculator.calculate("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3", "a,b"})
    void calculate_negative(String input) {
        assertThatThrownBy(() -> stringAddCalculator.calculate(input))
                .isInstanceOf(RuntimeException.class);
    }
}
