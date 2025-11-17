package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @Test
    void 덧셈() {
        int result = Calculator.plus(new TargetNumber("4", "2"));
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 뺄셈() {
        int result = Calculator.minus(new TargetNumber("4", "2"));
        assertThat(result).isEqualTo(2);
    }

    @Test
    void 곱셈() {
        int result = Calculator.multiplication(new TargetNumber("4", "2"));
        assertThat(result).isEqualTo(8);
    }

    @Test
    void 나눗셈() {
        int result = Calculator.division(new TargetNumber("4", "2"));
        assertThat(result).isEqualTo(2);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void null_공백_입력(String input) {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> Calculator.calculate(input));
    }




}
