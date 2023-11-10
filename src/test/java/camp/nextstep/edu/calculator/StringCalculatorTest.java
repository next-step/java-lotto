package camp.nextstep.edu.calculator;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class StringCalculatorTest {

    @NullAndEmptySource
    @ParameterizedTest
    void nullOrEmpty(String input) {
        assertThatThrownBy(() -> StringCalculator.calc(input))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
