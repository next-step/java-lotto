import domain.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {

    @DisplayName("덧셈 테스트")
    @CsvSource({"1 + 2, 3", "2 + 3, 5", "-1 + 2, 1", "1 + 3 + 5, 9", "1 + 2 + 3 + 4, 10"})
    @ParameterizedTest
    void calculateAdd(String string, Integer expected) {
        // When
        int result = Calculator.calculate(string);

        // Then
        assertThat(result).isEqualTo(expected);
    }
}
