import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {

    @Test
    void 덧셈_연산() {
        // given
        Number number = new Number(1);
        Number operand = new Number(3);
        List<Number> list = new ArrayList<>();
        Numbers numbers = new Numbers(list);
        numbers.register(number);
        numbers.register(operand);

        // when
        int result = numbers.sum().getNumber();

        // then
        assertThat(result).isEqualTo(4);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,5,3", "1,5:3", "//;\n1;5;3", "//;\n1;5,3"})
    void 연산자를_구분자기준_분리(String expression) {
        // when
        Numbers numbers = new Numbers(expression);

        //then
        assertThat(numbers.get(0).getNumber()).isEqualTo(1);
        assertThat(numbers.get(1).getNumber()).isEqualTo(5);
        assertThat(numbers.get(2).getNumber()).isEqualTo(3);
    }
}
