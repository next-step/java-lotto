package sequenceCalculatorTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import sequenceCalculator.SequenceCalculator;

public class SequenceCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("문자열이 null이거나 빈 공백 문자일 경우 IllegalArgumentException Throw")
    void input_NullOrEmpty(String input) {
        SequenceCalculator calculator = new SequenceCalculator();
        Assertions.assertThatThrownBy(() -> calculator.calculate(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("하나의 덧셈 계산")
    void A_Minus_B_Test(){
        SequenceCalculator calculator = new SequenceCalculator();
        Assertions.assertThat(calculator.calculate("1 + 2")).isEqualTo(3);
    }

    @Test
    @DisplayName("하나의 곱셈 계산")
    void A_Mul_B_Test(){
        SequenceCalculator calculator = new SequenceCalculator();
        Assertions.assertThat(calculator.calculate("2 * 3")).isEqualTo(6);
    }

    @Test
    @DisplayName("하나의 나눗셈 계산")
    void A_Divide_B_Test(){
        SequenceCalculator calculator = new SequenceCalculator();
        Assertions.assertThat(calculator.calculate("4 / 2")).isEqualTo(2);
    }
    @Test
    @DisplayName("하나의 뺄셈 계산")
    void A_Plus_B_Test(){
        SequenceCalculator calculator = new SequenceCalculator();
        Assertions.assertThat(calculator.calculate("8 - 2")).isEqualTo(6);
    }
    @Test
    @DisplayName("모든 사칙연산이 들어간 문자열 계산")
    void CALCULATE_WITH_ALL_BASIC_OPERATOR_TEST(){
        SequenceCalculator calculator = new SequenceCalculator();
        Assertions.assertThat(calculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
    }


}
