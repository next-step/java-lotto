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
    @DisplayName("더하기 테스트")
    void add() {
        assertEquals(DEFAULT_FIRST_ARG + DEFAULT_SECOND_ARG, Calculator.calculate(String.format("%d + %d", DEFAULT_FIRST_ARG, DEFAULT_SECOND_ARG)));
    }

    @Test
    @DisplayName("빼기 테스트")
    void subtract() {
        assertEquals(DEFAULT_FIRST_ARG - DEFAULT_SECOND_ARG, Calculator.calculate(String.format("%d - %d", DEFAULT_FIRST_ARG, DEFAULT_SECOND_ARG)));
    }

    @Test
    @DisplayName("곱하기 테스트")
    void multiply() {
        assertEquals(DEFAULT_FIRST_ARG * DEFAULT_SECOND_ARG, Calculator.calculate(String.format("%d * %d", DEFAULT_FIRST_ARG, DEFAULT_SECOND_ARG)));
    }

    @Test
    @DisplayName("나누기 테스트")
    void divide() {
        assertEquals(DEFAULT_FIRST_ARG / DEFAULT_SECOND_ARG, Calculator.calculate(String.format("%d / %d", DEFAULT_FIRST_ARG, DEFAULT_SECOND_ARG)));
    }

    @Test
    @DisplayName("입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException를 발생시킨다")
    void emptyInput() {
        assertThrows(IllegalArgumentException.class, () -> Calculator.calculate(null));
        assertThrows(IllegalArgumentException.class, () -> Calculator.calculate(""));
    }

    @Test
    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException를 발생시킨다")
    void notFourArithmeticSign() {
        assertThrows(IllegalArgumentException.class, () -> Calculator.calculate(String.format("%d . %d", DEFAULT_FIRST_ARG, DEFAULT_SECOND_ARG)));
    }

    @Test
    @DisplayName("사칙연산을 모두 포함하는 통합계산")
    void fourArithmeticSignIntegrate() {
        assertEquals((((DEFAULT_FIRST_ARG + DEFAULT_SECOND_ARG) - DEFAULT_THIRD_ARG) * DEFAULT_FOURTH_ARG) / DEFAULT_FIFTH_ARG,
                Calculator.calculate(String.format("%d + %d - %d * %d / %d", DEFAULT_FIRST_ARG, DEFAULT_SECOND_ARG, DEFAULT_THIRD_ARG, DEFAULT_FOURTH_ARG, DEFAULT_FIFTH_ARG)));
    }
}
