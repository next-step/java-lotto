import model.Calculate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculateTest {

    private Calculate calculate;

    @BeforeEach
    void setUp() {
        calculate = new Calculate();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2:3", "2:4:6"}, delimiter = ':')
    void plus(int firstInput, int secondInput, int resultInput){
        int result = calculate.plus(firstInput, secondInput);
        assertThat(result).isEqualTo(resultInput);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2:-1", "2:4:-2"}, delimiter = ':')
    void minus(int firstInput, int secondInput, int resultInput) {
        // when
        int result = calculate.minus(firstInput, secondInput);
        // then
        assertThat(result).isEqualTo(resultInput);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2:2", "2:4:8"}, delimiter = ':')
    void multiple(int firstInput, int secondInput, int resultInput) {
        // when
        int result = calculate.multiple(firstInput, secondInput);
        // then
        assertThat(result).isEqualTo(resultInput);
    }

    @ParameterizedTest
    @CsvSource(value = {"4:2:2", "32:4:8"}, delimiter = ':')
    void divide(int firstInput, int secondInput, int resultInput) {
        // when
        int result = calculate.divide(firstInput, secondInput);
        // then
        assertThat(result).isEqualTo(resultInput);
    }

}
