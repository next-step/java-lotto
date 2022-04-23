package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("문자열 사칙연산 계산기 테스트")
public class StringCalculatorTest {

    @Test
    @DisplayName("문자열을 입력받아 계산한 후 결과를 출력한다.")
    void StringCalculatorTest() {
        int result = StringCalculator.calculate("2 + 3 * 4 / 2");

        assertThat(result).isEqualTo(10);
    }
}
