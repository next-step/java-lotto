package calculator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class StringCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    void fail_for_null_or_empty(String input) {
        assertThatThrownBy(() -> StringCalculator.calculate(input))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
