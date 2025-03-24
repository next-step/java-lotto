import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {
    @DisplayName("덧셈 테스트")
    @Test
    void addTest() {
        int result = Calculator.run("2 + 3");
        assertEquals(5, result);
    }

    @DisplayName("뺄셈 테스트")
    @Test
    void subtractTest() {
        int result = Calculator.run("5 - 3");
        assertEquals(2, result);
    }

    @DisplayName("곱셈 테스트")
    @Test
    void multiplyTest() {
        int result = Calculator.run("2 * 3");
        assertEquals(6, result);
    }

    @DisplayName("나눗셈 테스트")
    @Test
    void divideTest() {
        int result = Calculator.run("6 / 3");
        assertEquals(2, result);
    }

    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void nullOrEmptyTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator.run(null);
        }).withMessage("입력 값이 null이거나 빈 공백 문자입니다.");
    }

    @DisplayName("지원하지 않는 연산자일 경우")
    @Test
    void invalidOperatorTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator.run("2 % 3");
        }).withMessage("지원하지 않는 연산자입니다.");
    }
}
