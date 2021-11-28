package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

class OperandsTest {

    @DisplayName("주어진 피연사자들의 합을 구할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5:15", "2,3,4:9", "100,102,103:305"}, delimiter = ':')
    void sumOf(String value, int expected) {
        // given
        List<String> values = Arrays.asList(value.split(","));
        Operands operands = Operands.from(values);

        // when
        int result = operands.sumOf();

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
