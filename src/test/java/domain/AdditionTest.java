package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AdditionTest {

    @ParameterizedTest(name = "주어진 인자 값을 더 한다. {0} + {1} = {2}")
    @CsvSource(value = {"1:2:3", "2:3:5", "3:4:7"}, delimiter = ':')
    void plusTest(int first, int second, int expected) {
        Addition addition = new Addition();
        assertThat(addition.calculate(first, second)).isEqualTo(expected);
    }
}
