package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    @DisplayName("입력받은 숫자들의 합을 구한다.")
    void sum() {
        //given
        int left = 5;
        int right = 10;

        //when
        int sum = Calculator.sum(left, right);

        //then
        assertThat(sum).isEqualTo(15);
    }
}
