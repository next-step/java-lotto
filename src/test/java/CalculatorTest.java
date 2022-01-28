import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void 덧셈_연산() {
        Number number = new Number(1);
        Number operand = new Number(3);
        List<Number> list = new ArrayList<>();
        Numbers numbers = new Numbers(list);
        numbers.register(number);
        numbers.register(operand);

        assertThat(numbers.sum().getNumber()).isEqualTo(4);
    }
}
