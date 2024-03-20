package calculator;

import calculator.domain.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @DisplayName("입력받은 문자열 배열의 길이가 짝수면 IllegalArgumentException을 던진다.")
    @Test
    void validate() {
        final String[] targets = new String[]{"3", "-", "2", "+", "-1", "-"};

        assertThatIllegalArgumentException().isThrownBy(() -> Calculator.calculate(targets));
    }

    @DisplayName("입력받은 문자열에 대한 수식을 계산한다")
    @Test
    void calculate() {
        final String[] targets = new String[]{"3", "-", "2", "+", "-1"};
        int result = Calculator.calculate(targets);

        assertThat(result).isEqualTo(0);
    }

    @DisplayName("입력받은 문자열이 숫자위치에 숫자가 없을 경우 NumberFormat Exception을 발생시킨다.")
    @Test
    void calculateThrowExceptionWhenInvalidTargets() {
        final String[] targets = new String[]{"3", "-", "2", "+", "ㅁㄴㅇㄹㅁㄴㅇㄹ"};

        assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(() -> Calculator.calculate(targets));
    }
}
