package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @ParameterizedTest
    @CsvSource({"5, 10, 15", "0, 10, 10", "0, 0, 0"})
    @DisplayName("입력받은 숫자들의 합을 구한다.")
    void sum(int left, int right, int expectedAnswer) {
        //when
        int sum = Calculator.sum(left, right);

        //then
        assertThat(sum).isEqualTo(expectedAnswer);
    }
}
