package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringAddCalculatorTest {

    private StringAddCalculator stringAddCalculator;

    @BeforeEach
    void setUp() {
        stringAddCalculator = new StringAddCalculator();
    }


    @DisplayName("null 값이나 빈 값은 0을 반환한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void addTest(String input) {
        int result = stringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(0);
    }
}
