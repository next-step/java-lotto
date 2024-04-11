package calculator.calculate;

import calculator.calc.Calculator;
import calculator.calc.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AddTest {

    @Test
    @DisplayName("식을 입력하면 덧셈을 수행한다.")
    public void addTest(){
        int result = Operator.ADDITION.apply(1,2);

        assertThat(result).isEqualTo(3);
    }
}
