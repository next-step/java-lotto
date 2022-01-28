import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,5,3", "1,5:3", "//;\n1;5;3", "//;\n1;5,3"})
    void 연산자를_구분자기준_분리(String expression) {
        // when
        Numbers numbers = new Numbers(expression);

        // then
        assertThat(numbers.get(0).getNumber()).isEqualTo(1);
        assertThat(numbers.get(1).getNumber()).isEqualTo(5);
        assertThat(numbers.get(2).getNumber()).isEqualTo(3);
    }

    @Test
    void 계산기_동작_테스트() {
        // given
        Numbers numbers = new Numbers("1,5,3");
        StringCalculator stringCalculator = StringCalculator.from(numbers);

        // when
        Number result = stringCalculator.calculate();

        // then
        assertThat(result.getNumber()).isEqualTo(9);
    }
}
