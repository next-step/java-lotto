package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("공백이 들어오면 0으로 리턴한다. ")
    void add(String input) {
        StringCalculate stringCalculate = new StringCalculate();
        assertThat(stringCalculate.add(input)).isZero();
    }
}
