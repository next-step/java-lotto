package com.calculator.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringCalculatorTest {

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", "  ", "    "})
    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw 테스트")
    void invalid_input_null_or_blank(String inputString) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.calculate(inputString);
        });
    }

    @Test
    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException throw 테스트")
    void invalid_input_operation_symbol() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.calculate("2 ) 3 * 5");
        });
    }

    @Test
    @DisplayName("사칙 연산을 모두 포함하는 기능 테스트")
    void calculate() {
        Assertions.assertEquals(10, StringCalculator.calculate("2 + 3 * 4 / 2"));
    }

    @Test
    @DisplayName("덧셈 테스트")
    void add() {
        Assertions.assertEquals(5, StringCalculator.calculate("2 + 3"));
    }

    @Test
    @DisplayName("뺄셈 테스트")
    void withdraw() {
        Assertions.assertEquals(2, StringCalculator.calculate("5 - 3"));
    }

    @Test
    @DisplayName("곱셈 테스트")
    void multiply() {
        Assertions.assertEquals(15, StringCalculator.calculate("5 * 3"));
    }

    @Test
    @DisplayName("나눗셈 테스트")
    void division() {
        Assertions.assertEquals(3, StringCalculator.calculate("15 / 5"));
    }
}
