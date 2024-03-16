package caculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    @DisplayName("입력에 따라 연산을 진행한다 - plus test")
    void plusCalculateTest(){
        Calculator calculator = new Calculator(new Operator());
        assertThat(calculator.calculate(List.of("1","+","3","+","2"))).isEqualTo(6);
    }
}
