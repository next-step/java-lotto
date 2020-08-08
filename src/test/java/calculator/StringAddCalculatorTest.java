package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringAddCalculatorTest {

    @Test
    @DisplayName("빈문자 또는 null 입력 시 0 반환")
    public void calculator_nullOrEmpty_returnZero() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나 입력 시 해당 숫자 반환")
    public void calculator_singleNum_returnDirect() {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자 입력 후 합 반환")
    public void calculator_commaSeparator_returnSum() {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("쉼표와 콜론 구분자 동시 사용")
    public void calculator_commaWithColon_returnSum() {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자 사용")
    public void calculator_customSeparator_returnSum() {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수 입력 시 예외 발생")
    public void calculator_negativeInput_exceptThrown() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
