package calculators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("기본 구분자 입력받아 합 반환하기")
    void basicSeparator() {
        final String input = "1,2:3";
        int sum = calculator.calculate(input);

        assertEquals(sum, 6);
    }

    @Test
    @DisplayName("커스텀 구분자 입력받아 합 반환하기")
    void customSeparator() {
        final String input = "//;\n1;2;3";
        int sum = calculator.calculate(input);

        assertEquals(sum, 6);
    }

    @Test
    @DisplayName("음수가 전달되는 경우 RuntimeException 발생")
    void negative() {
        assertThrows(RuntimeException.class, () -> {
            final String input = "//;\n-1;2;3";
            calculator.calculate(input);
        });
    }

    @Test
    @DisplayName("문자 값이 전달되는 경우 RuntimeException 발생")
    void text() {
        assertThrows(RuntimeException.class, () -> {
            final String input = "//;\na;2;3";
            calculator.calculate(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @NullAndEmptySource
    @DisplayName("null, empty ,공백일 경우 RuntimeException 발생")
    void blank(final String input) {
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(input);
        });
    }

    @Test
    @DisplayName("입력 값 1개 합산")
    void one() {
        final String input = "1";
        int sum = calculator.calculate(input);
        assertEquals(sum, 1);
    }
}
