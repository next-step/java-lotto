package step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OperatorTest {

    @ParameterizedTest
    @CsvSource(value = {"+:1:2:3", "-:4:2:2", "*:1:10:10", "/:10:2:5"}, delimiter = ':')
    void calculate(String operator, int first, int second, int expected) {
        Assertions.assertThat(new Operator(operator).calculate(first, second)).isEqualTo(expected);
    }
}