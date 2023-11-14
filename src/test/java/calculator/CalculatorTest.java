package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static calculator.Calculator.calculation;
import static calculator.exception.CustomExceptionCode.*;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"2 + 3:5", "2 - 3:-1", "2 * 3:6", "4 / 2:2"}, delimiter = ':')
    void calculation_정상수식입력_정상출력(String input, int expected) {
        assertEquals(expected, calculation(input));
    }

    @Test
    void calculation_null입력_오류출력() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculation(null))
                .withMessage(NULL_OR_BLANK_INPUT.getMessage());
    }

    @Test
    void calculation_빈값입력_오류출력() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculation(" "))
                .withMessage(NULL_OR_BLANK_INPUT.getMessage());
    }

    @Test
    void calculation_잘못된연산자입력_오류출력() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculation("2 & 3 + 2 * 4"))
                .withMessage(NOT_FOUR_BASIC_OPERATIONS.getMessage());
    }

    @Test
    void calculation_정상복합수식입력_정상출력() {
        assertEquals(10, calculation("2 + 3 * 4 / 2"));
    }

    @Test
    void calculation_미완성수식입력_오류출력() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculation("2 - 3 + 2 * 4 +"))
                .withMessage(INCOMPLETED_FORMULA.getMessage());
    }

    @Test
    void calculation_연속숫자입력_오류출력() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculation("2 - 3 3 2 * 4 +"))
                .withMessage(NOT_FOUR_BASIC_OPERATIONS.getMessage());
    }

}