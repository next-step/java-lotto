import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @Test
    void 입력값이_null_또는_빈_공백은_에러() {
        assertThatThrownBy(() -> new Calculator(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 연산자와_피연산자로_분리() {
        Calculator calculator = new Calculator("2 + 3 * 4 / 2");
        calculator.split();
        assertThat(calculator.getOperator()).isEqualTo(new ArrayList<String>(Arrays.asList("+","*","/")));
        assertThat(calculator.getOperand()).isEqualTo(new ArrayList<Integer>(Arrays.asList(2,3,4,2)));
    }
}
