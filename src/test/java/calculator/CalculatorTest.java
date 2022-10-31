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
        CalculatorDatas calculatorDatas = new CalculatorDatas(data);
        assertThat(calculatorDatas.startCalculator()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 - 1"})
    @DisplayName("빼기 테스트")
    void minusTest(String data){
        CalculatorDatas calculatorDatas =  new CalculatorDatas(data);
        assertThat(calculatorDatas.startCalculator()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"4 / 2"})
    @DisplayName("나누기 테스트")
    void divideTest(String data){
        CalculatorDatas calculatorDatas =  new CalculatorDatas(data);
        assertThat(calculatorDatas.startCalculator()).isEqualTo(2);
    }

    @ParameterizedTest
    @ValueSource(strings = {"4 * 2"})
    @DisplayName("곱하기 테스트")
    void multiplyTest(String data){
        CalculatorDatas calculatorDatas =  new CalculatorDatas(data);
        assertThat(calculatorDatas.startCalculator()).isEqualTo(8);
    }
}
