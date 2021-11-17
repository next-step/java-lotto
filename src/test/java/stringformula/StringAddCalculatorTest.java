package stringformula;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class StringAddCalculatorTest {

    @Test
    @DisplayName("calculate 메소드는 수식을 계산하여 값을 반환한다")
    public void 테스트_calculate_수식_계산_결과_반환() {
        StringAddCalculator calculator = new StringAddCalculator();
        assertThat(calculator.calculate("\\;1;2;3")).isEqualTo(new Number(6));
        assertThat(calculator.calculate("1,2:5")).isEqualTo(new Number(8));
    }
}