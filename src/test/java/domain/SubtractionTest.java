package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SubtractionTest {

    @ParameterizedTest(name = "주어진 인자 값을 뺀다. {0} - {1} = {2}")
    @CsvSource(value = {"3:2:1", "5:2:3", "4:4:0"}, delimiter = ':')
    void minusTest(int first, int second, int expected) {
        Subtraction subtraction = new Subtraction();
        assertThat(subtraction.calculate(first, second)).isEqualTo(expected);
    }
}
