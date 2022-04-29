package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringCalculatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    void 입력값_null_이거나_빈공백문자열(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.splitAndCalculate(input);
        });
    }

    @Test
    void 사칙연산_모두_포함하여_계산() {
        assertThat(StringCalculator.splitAndCalculate("2 + 3 * 4 / 2")).isEqualTo(10);
    }
}
