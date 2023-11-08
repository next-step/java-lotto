package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static calculator.Calculation.*;

public class CalculationTest {


    @ParameterizedTest
    @CsvSource(value = {"1:2:3", "2:23:25", "-1:2:1", "6:-22:-16", "5:95:100"}, delimiter = ':')
    @DisplayName("값을 더하여 리턴되는 값을 확인")
    void 더하기_값_확인(int first, int second, int result) {
        int number = plus(first, second);

        Assertions.assertThat(number).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2:-1", "23:23:0", "-1:2:-3", "66:22:44", "95:90:5"}, delimiter = ':')
    @DisplayName("값을 빼서 리턴되는 값을 확인")
    void 빼기_값_확인(int first, int second, int result) {
        int number = subtract(first, second);

        Assertions.assertThat(number).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2:2", "23:26:598", "-6:2:-12", "666:5432:3617712", "95:10:950"}, delimiter = ':')
    @DisplayName("값을 곱하여 리턴되는 값을 확인")
    void 곱하기_값_확인(int first, int second, int result) {
        int number = multiply(first, second);

        Assertions.assertThat(number).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"8:2:4", "23:2:11", "-6:8:0", "666:5:133", "95:10:9"}, delimiter = ':')
    @DisplayName("값을 나누어 리턴되는 값을 확인")
    void 나누기_값_확인(int first, int second, int result) {
        int number = divide(first, second);

        Assertions.assertThat(number).isEqualTo(result);
    }


}
