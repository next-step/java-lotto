package step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class OperaterTest {
    @ParameterizedTest
    @ValueSource(strings = {"2+5"})
    @DisplayName("덧셈 테스트")
    void 덧셈(String input) {
        StringCalculator cal = new StringCalculator(input);

        Assertions.assertThat(cal.calculateExpression()).isEqualTo(7);
    }

    @ParameterizedTest
    @ValueSource(strings = {"5-2"})
    @DisplayName("뺄셈 테스트")
    void 뺄셈(String input) {
        StringCalculator cal = new StringCalculator(input);

        Assertions.assertThat(cal.calculateExpression()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"5*2"})
    @DisplayName("곱셈 테스트")
    void 곱셈(String input) {
        StringCalculator cal = new StringCalculator(input);

        Assertions.assertThat(cal.calculateExpression()).isEqualTo(10);
    }


    @ParameterizedTest
    @ValueSource(strings = {"5/2"})
    @DisplayName("나눗셈 테스트")
    void 나눗셈(String input) {
        StringCalculator cal = new StringCalculator(input);

        Assertions.assertThat(cal.calculateExpression()).isEqualTo(2);
    }


    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2"})
    @DisplayName("복잡한 연산 테스트")
    void 복잡한_연산(String input) {
        StringCalculator cal = new StringCalculator(input);

        Assertions.assertThat(cal.calculateExpression()).isEqualTo(10);
    }

    @ParameterizedTest
    @ValueSource(strings = {"^"})
    @DisplayName("잘못된 연산기호인지 확인한다")
    void 잘못된_연산기호(String input) {

        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->
                        OperaterSelection.selection(input))
                .withMessage("잘못된 기호");

    }


}
