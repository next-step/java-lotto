package calculator.calculate;

import calculator.calc.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AddTest {

    @Test
    @DisplayName("식을 입력하면 덧셈을 수행한다.")
    public void addTest(){
        Calculator calculator = new Calculator();
        int result = calculator.add(1,2);

        assertThat(result).isEqualTo(3);
    }
}
