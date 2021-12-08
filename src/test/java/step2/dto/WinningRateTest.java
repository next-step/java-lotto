package step2.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class WinningRateTest {

    @ParameterizedTest
    @CsvSource(value = {"1.1= 1.1", "20.32= 20.32", "0.56= 0.56", "100.0= 100.0"}, delimiter = '=')
    @DisplayName("객체 값을 정상적으로 비교한다")
    public void equalsTest(float input, float expected) {
        assertThat(new WinningRate(input)).isEqualTo(new WinningRate(expected));
    }
}
