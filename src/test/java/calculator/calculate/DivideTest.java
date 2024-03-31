package calculator.calculate;

import calculator.calc.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DivideTest {

    @Test
    @DisplayName("계산식을 입력하면 나눗셈을 반환한다.")
    public void divideTest(){
        Calculator calculator = new Calculator();
        int result = calculator.divide(4,2);

        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("계산식을 입력하면 나눗셈을 정수 내림하여 반환한다. ")
    public void divideFloorTest(){
        Calculator calculator = new Calculator();
        int result = calculator.divide(2, 3);

        assertThat(result).isEqualTo(0);
    }
}
