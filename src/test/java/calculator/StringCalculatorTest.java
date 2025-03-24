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

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    public void splitAndCalculate_빈갑체크(String input){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.splitAndCalculate(input);
        });
    }

    @Test
    public void splitAndCalculate(){
        String input = "2 + 3 * 4 / 2";
        assertThat(StringCalculator.splitAndCalculate(input)).isEqualTo(10);
    }

    @Test
    public void calculateInOrder() {
        String[] inputs = {"2", "+", "3", "*", "4", "/", "2"};
        assertThat(StringCalculator.calculateInOrder(inputs)).isEqualTo(10);
    }

    @Test
    public void split() {
        String[] result = StringCalculator.split("3 * 2");
        assertThat(result).containsExactly("3", "*", "2");
    }

    @Test
    public void toInt() {
        int result = StringCalculator.toInt("3");
        assertThat(result).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    public void 빈값체크(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.isBlank(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"t"})
    public void 사칙연산아닐때오류발생(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Operator.getOperator(input);
        });
    }

}
