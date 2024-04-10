package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {

    @BeforeEach
    void setUp() {

    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 2:3", "2 + 3:5", "3 + 4:7"}, delimiter = ':')
    @DisplayName("덧셈")
    int addition() {
        return 0;
    }

    @ParameterizedTest
    @CsvSource(value = {"1 - 1:0", "1 - 2:-1", "2 - 1:1"}, delimiter = ':')
    @DisplayName("뺄셈")
    int substraction() {
        return 0;
    }

    @ParameterizedTest
    @CsvSource(value = {"2 * -1:-2", "2 * 0:0", "2 * 1:2"}, delimiter = ':')
    @DisplayName("곱셈")
    int multiplication() {
        return 0;
    }

    @ParameterizedTest
    @CsvSource(value = {"4 / 1:4", "4 / 2:2", "4 / 4:1"}, delimiter = ':')
    @DisplayName("나눗셈")
    int division() {
        return 0;
    }

    @ParameterizedTest
    @CsvSource(value = {"1 ! 2:3", "2 @ 3:6", "4 # 5:0"}, delimiter = ':')
    @DisplayName("사칙연산 기호 아님")
    int notFourBasicOperations() {
        return 0;
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  ", "\t", "\n"})
    @DisplayName("사칙연산 기호 아님")
    int nullOrEmptyInput(String input) {
        return 0;
    }

}