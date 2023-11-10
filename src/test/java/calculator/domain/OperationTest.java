package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class OperationTest {

    @ParameterizedTest
    @CsvSource(value = {"+:PLUS", "-:SUBTRACT", "*:MULTIPLY", "/:DIVIDE"}, delimiter = ':')
    void 사칙연산_기호_확인(String sign, String name) {
        Operation operation = Operation.findOperationBySign(sign);
        Assertions.assertThat(operation.name()).isEqualTo(name);
    }

    @ParameterizedTest
    @CsvSource(value = {"+:13", "-:7", "*:30", "/:3"}, delimiter = ':')
    void 사칙연산_기호_계산결과_확인(String sign, int result) {
        int number1 = 10;
        int number2 = 3;
        Operation operation = Operation.findOperationBySign(sign);
        Assertions.assertThat(operation.calculate(number1, number2)).isEqualTo(result);
    }

}
