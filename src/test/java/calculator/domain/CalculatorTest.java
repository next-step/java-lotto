package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @Test
    void 덧셈() {
        assertThat(new TargetNumber(4,2).plus()).isEqualTo(6);
    }

    @Test
    void 뺄셈() {
        assertThat(new TargetNumber(4,2).minus()).isEqualTo(2);
    }

    @Test
    void 곱셈() {
        assertThat(new TargetNumber(4,2).multiplication()).isEqualTo(8);
    }

    @Test
    void 나눗셈() {
        assertThat(new TargetNumber(4,2).division()).isEqualTo(2);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void null_공백_입력(String input) {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> Calculator.calculate(input));
    }

    @Test
    void 연산하기() {
        assertThat(Calculator.calculate("10 + 2 - 5 * 4 / 2")).isEqualTo(14);
    }




}
