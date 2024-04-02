package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorTest {
    @ParameterizedTest
    @CsvSource(value = {"+:1:3:4", "/:4:3:1", "*:3:4:12", "-:5:2:3"}, delimiter = ':')
    @DisplayName("연산 테스트")
    public void calculateTest(String Operator, Integer num1, Integer num2, Integer result) {
        assertThat(calculator.domain.Operator.calculate(Operator, num1, num2)).isEqualTo(result);
    }
}