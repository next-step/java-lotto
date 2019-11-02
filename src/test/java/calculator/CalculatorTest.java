package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    private StringCalculate stringCalculate;

    @BeforeEach
    void setUp() {
        stringCalculate = new StringCalculate();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("공백이 들어오면 0으로 리턴한다. ")
    void add(String input) {
        assertThat(stringCalculate.add(input)).isZero();
    }
}
