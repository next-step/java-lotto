package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    @DisplayName("덧셈 테스트")
    void addition() {
        String source = "2 + 3";

        int result = calculator.splitAndCalculate(source);

        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("뺄셈 테스트")
    void subtraction() {
        String source = "5 - 2";

        int result = calculator.splitAndCalculate(source);

        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("곱셈 테스트")
    void multiplication() {
        String source = "5 * 2";

        int result = calculator.splitAndCalculate(source);

        assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("나눗셈 테스트")
    void division() {
        String source = "10 / 2";

        int result = calculator.splitAndCalculate(source);

        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("사칙연산 테스트")
    void arithmeticOperation() {
        String source = "2 + 3 * 4 / 2 - 5";

        int result = calculator.splitAndCalculate(source);

        assertThat(result).isEqualTo(5);
    }

    @DisplayName("빈 문자열, Null 예외 처리")
    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmptySource(String source) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> calculator.splitAndCalculate(source));
    }

    @Test
    @DisplayName("사칙연산 이외의 기호 예외 처리")
    void invalidArithmeticOperation() {
        String source = "2 _ 3";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> calculator.splitAndCalculate(source));
    }
}