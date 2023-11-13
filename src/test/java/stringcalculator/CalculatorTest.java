package stringcalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import stringcalculator.model.Calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 빈값_확인(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Calculator(input);
        });
    }

    @Test
    void 사칙연산_계산_확인() {
        String input = "2 + 3 * 4 / 2";
        Calculator cal = new Calculator(input);
        int actual = cal.calculate();
        assertThat(actual).isEqualTo(10);
    }
}
