package step1;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculatorTest {
    @ParameterizedTest
    @DisplayName("입력 값이 없을 경우 예외 발생")
    @NullSource
    @ValueSource(strings={"", "  "})
    public void emptyInputTest(String str) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Calculator(str);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사칙연산 수행 검증")
    public void calculate() {
        String str = "1 + 2 * 3 - 1 / 2";

        Calculator calc = new Calculator(str);

        AssertionsForClassTypes.assertThat(calc.calculate())
                .isEqualTo(4);
    }
}