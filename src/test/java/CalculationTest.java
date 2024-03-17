import model.Calculation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculationTest {

    private Calculation calculation;

    @BeforeEach
    void setUp() {
        calculation = new Calculation();
    }

    @ParameterizedTest
    @DisplayName("더하기 계산 Test")
    @CsvSource(value = {"1:2:3", "2:4:6"}, delimiter = ':')
    void plus(int firstInput, int secondInput, int resultInput){
        int result = calculation.plus(firstInput, secondInput);
        assertThat(result).isEqualTo(resultInput);
    }

    @ParameterizedTest
    @DisplayName("빼기 계산 Test")
    @CsvSource(value = {"1:2:-1", "2:4:-2"}, delimiter = ':')
    void minus(int firstInput, int secondInput, int resultInput) {
        // when
        int result = calculation.minus(firstInput, secondInput);
        // then
        assertThat(result).isEqualTo(resultInput);
    }

    @ParameterizedTest
    @DisplayName("곱하기 계산 Test")
    @CsvSource(value = {"1:2:2", "2:4:8"}, delimiter = ':')
    void multiple(int firstInput, int secondInput, int resultInput) {
        // when
        int result = calculation.multiple(firstInput, secondInput);
        // then
        assertThat(result).isEqualTo(resultInput);
    }

    @ParameterizedTest
    @DisplayName("나누기 계산 Test")
    @CsvSource(value = {"4:2:2", "32:4:8"}, delimiter = ':')
    void divide(int firstInput, int secondInput, int resultInput) {
        // when
        int result = calculation.divide(firstInput, secondInput);
        // then
        assertThat(result).isEqualTo(resultInput);
    }

}
