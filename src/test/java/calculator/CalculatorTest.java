package calculator;

import calculator.domain.CalculatorDatas;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"1 + 2"})
    @DisplayName("더하기 테스트")
    void plusTest(String data){
        Calculator calculator = new Calculator(data);
        assertThat(calculator.startCalculate()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 - 1"})
    @DisplayName("빼기 테스트")
    void minusTest(String data){
        Calculator calculator = new Calculator(data);
        assertThat(calculator.startCalculate()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"4 / 2"})
    @DisplayName("나누기 테스트")
    void divideTest(String data){
        Calculator calculator = new Calculator(data);
        assertThat(calculator.startCalculate()).isEqualTo(2);
    }

    @ParameterizedTest
    @ValueSource(strings = {"4 * 2"})
    @DisplayName("곱하기 테스트")
    void multiplyTest(String data){
        Calculator calculator = new Calculator(data);
        assertThat(calculator.startCalculate()).isEqualTo(8);
    }
}
