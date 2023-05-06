package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MultiplicationTest {

    @ParameterizedTest(name = "주어진 인자 값을 곱한다. {0} * {1} = {2}")
    @CsvSource(value = {"3:2:6", "5:2:10", "4:4:16"}, delimiter = ':')
    void minusTest(int first, int second, int expected) {
        Multiplication multiplication = new Multiplication();
        assertThat(multiplication.calculate(first, second)).isEqualTo(expected);
    }
}
