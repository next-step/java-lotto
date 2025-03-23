package calculator;

import caculator.Operator;
import caculator.StringCalculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringCalculatorTest {
    @Test
    public void 더하기(){
        assertThat(Operator.calculate("+", 1,2)).isEqualTo(3);
    }
    @Test
    public void 빼기(){
        assertThat(Operator.calculate("-", 3,2)).isEqualTo(1);
    }
    @Test
    public void 곱셈(){
        assertThat(Operator.calculate("*", 1,2)).isEqualTo(2);
    }
    @Test
    public void 나누기(){
        assertThat(Operator.calculate("/", 4,2)).isEqualTo(2);
    }

    @Test
    public void split(){
        String[] result = StringCalculator.split("3 * 2");
        assertThat(result).containsExactly("3", "*", "2");
    }

    @Test
    public void toInt(){
        int result = StringCalculator.toInt("3");
        assertThat(result).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    public void 빈값체크(String input) {
        assertTrue(StringCalculator.isBlank(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"t"})
    public void 사칙연산아닐때오류발생(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Operator.getOperator(input);
        });
    }

}
