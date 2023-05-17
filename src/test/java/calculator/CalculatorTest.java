package calculator;

import calculator.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    static final int DEFAULT_FIRST_ARG = 2;
    static final int DEFAULT_SECOND_ARG = 3;
    static final int DEFAULT_THIRD_ARG = 4;
    static final int DEFAULT_FOURTH_ARG = 5;
    static final int DEFAULT_FIFTH_ARG = 6;

    @Test
    @DisplayName("입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException를 발생시킨다")
    void emptyInput() {
        assertThrows(IllegalArgumentException.class, () -> Calculator.create(null));
        assertThrows(IllegalArgumentException.class, () -> Calculator.create(""));
    }

    @Test
    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException를 발생시킨다")
    void notFourArithmeticSign() {
        assertThrows(IllegalArgumentException.class, () -> Calculator.create(String.format("%d . %d", DEFAULT_FIRST_ARG, DEFAULT_SECOND_ARG)));
    }

    @Test
    @DisplayName("사칙연산을 모두 포함하는 통합계산")
    void fourArithmeticSignIntegrate() {
        Calculator calculator = Calculator.create(String.format("%d + %d - %d * %d / %d", DEFAULT_FIRST_ARG, DEFAULT_SECOND_ARG, DEFAULT_THIRD_ARG, DEFAULT_FOURTH_ARG, DEFAULT_FIFTH_ARG));
        assertEquals((((DEFAULT_FIRST_ARG + DEFAULT_SECOND_ARG) - DEFAULT_THIRD_ARG) * DEFAULT_FOURTH_ARG) / DEFAULT_FIFTH_ARG,
                calculator.calculate());
    }
}
