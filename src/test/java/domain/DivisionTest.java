package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DivisionTest {

    @ParameterizedTest(name = "주어진 인자 값을 나눈다. {0} / {1} = {2}")
    @CsvSource(value = {"3:2:1", "5:2:2", "10:9:1"}, delimiter = ':')
    void minusTest(int first, int second, int expected) {
        Division division = new Division();
        assertThat(division.calculate(first, second)).isEqualTo(expected);
    }
}
