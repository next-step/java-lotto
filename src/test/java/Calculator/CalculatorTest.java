package Calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void start(){
        calculator = new Calculator();
    }

    @Test
    void 계산기_생성(){
        assertThat(calculator).isEqualTo(new Calculator());
    }

    @Test
    void 빈문자열_또는_null_입력(){
        assertThat(calculator.calculateText("")).isEqualTo(0);
        assertThat(calculator.calculateText(null)).isEqualTo(0);
    }





}
