package calculator;

import calculator.domain.CalculatorDatas;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    @DisplayName("더하기 테스트")
    void plusTest(String data){
        CalculatorDatas calculatorDatas = CalculatorDatas.numbersMake(Arrays.asList("1 + 2"));
        assertThat(calculatorDatas.startCalculator()).isEqualTo(3);
    }
}
