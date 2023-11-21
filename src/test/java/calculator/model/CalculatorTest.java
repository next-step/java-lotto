package calculator.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {

    @Test
    @DisplayName("Expression이 숫자 하나인 경우")
    public void 숫자_하나_연산() {
        Assertions.assertThat(Calculator.run("3"))
                .isEqualTo(3);
    }

    @Test
    public void 사칙연산() {
        Assertions.assertThat(Calculator.run("1 + 2 / 3 - 1 * 7"))
                .isEqualTo(0);
    }
}
