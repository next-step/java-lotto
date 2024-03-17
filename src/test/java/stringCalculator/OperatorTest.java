package stringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class OperatorTest {
    private final long TEN = 10;
    private final long FIVE = 5;
    private final long ZERO = 0;

    @Test
    @DisplayName("덧셈 연산 성공")
    void processWithValidation__ShouldReturnAddition() {
        // given, when
        Operator addition = Operator.ADDITION;
        long result = addition.process(TEN, FIVE);

        // then
        assertThat(result).isEqualTo(15);
    }

    @Test
    @DisplayName("뺄셈 연산 성공")
    void processWithValidation__ShouldReturnSubtraction() {
        // given, when
        Operator addition = Operator.SUBTRACTION;
        long result = addition.process(TEN, FIVE);

        // then
        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("곱하기 연산 성공")
    void processWithValidation__ShouldReturnMultiplication() {
        // given, when
        Operator addition = Operator.MULTIPLICATION;
        long result = addition.process(TEN, FIVE);

        // then
        assertThat(result).isEqualTo(50);
    }

    @Test
    @DisplayName("나누기 연산 성공")
    void processWithValidation__ShouldReturnDivision() {
        // given, when
        Operator addition = Operator.DIVISION;
        long result = addition.process(TEN, FIVE);

        // then
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("나누기 연산 실패 : 0으로 나눔")
    void processWithValidation__ShouldThrowArithmeticException() {
        // given
        Operator operator = Operator.DIVISION;
        // when, then
        assertThatThrownBy(() -> operator.process(TEN, ZERO))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("Division by zero is not allowed");
    }

    @Test
    void processWithValidation__ShouldThrowIllegalArgumentException() {
        // given
        // when, then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Operator.findMark("?");
        });
    }
}
