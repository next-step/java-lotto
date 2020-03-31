import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    private stringAddCalculator stringAddCalculator;

    @BeforeEach
    public void setUp() {
        stringAddCalculator = new stringAddCalculator();
    }

    @Test
    @DisplayName("콤마 또는 콜론 구분자를 기준으로 분리한 각 숫자의 합을 리턴한다")
    public void splitAndSumReturnsSumOfNumbersInString() {
        int result = stringAddCalculator.splitAndSum("1,2:3");

        assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 또는 빈 문자열이 입력될 경우 0을 리턴한다")
    public void splitAndSumWithNullOrEmptyReturnsZero(String input) {
        int result = stringAddCalculator.splitAndSum(input);

        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나만 있는 문자열을 입력한 경우 그대로 그 숫자를 리턴한다")
    public void splitAndSumWithSingleNumberReturnsThatNumber() {
        int result = stringAddCalculator.splitAndSum("1");

        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("음수가 입력된 경우 RuntimeException이 발생한다")
    public void splitAndSumWithNegativeNumberThrowRuntimeException() {
        assertThatThrownBy(() -> stringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("숫자 이외의 값이 입력된 경우 NumberFormatException이 발생한다")
    public void splitAndSumWithNoneNumberThrowNumberFormatException() {
        assertThatThrownBy(() -> stringAddCalculator.splitAndSum("#,b,c"))
                .isInstanceOf(NumberFormatException.class);
    }

    @Test
    @DisplayName("//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다")
    public void splitAndSumWithCustomDelimiter() {
        int result = stringAddCalculator.splitAndSum("//&\n1&2&3");

        assertThat(result).isEqualTo(result);
    }
}
