
package stringAddCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringAddCalculatorTest {

    @Test
    @DisplayName("쉼표와 콜론 기준으로 분리한 숫자의 합을 구한다.")
    public void splitAndSum() {
        assertThat(StringAddCalculator.splitAndSum("1,2")).isEqualTo(3);
        assertThat(StringAddCalculator.splitAndSum("1,2,3")).isEqualTo(6);
        assertThat(StringAddCalculator.splitAndSum("1,2:3")).isEqualTo(6);
        assertThat(StringAddCalculator.splitAndSum("1:2:3:4")).isEqualTo(10);
        assertThat(StringAddCalculator.splitAndSum("1:2,3:4")).isEqualTo(10);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈 문자열 또는 null인 경우 0을 반환한다.")
    public void splitAndSum_nullOrEmpty(String value) {
        assertThat(StringAddCalculator.splitAndSum(value)).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나인 경우 해당 숫자를 반환한다.")
    public void splitAndSum_one() {
        assertThat(StringAddCalculator.splitAndSum("1")).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,a", "1,$:3", "-1,3", "1+3", "-1,-2"})
    @DisplayName("숫자 이외의 값 또는 음수를 전달하는 경우 예외를 발생시킨다.")
    public void splitAndSum_IllegalArguments(String value) {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(value)).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("커스텀 구분자를 지정할 수 있다.")
    public void splitByCustomDelimiter() {

    }
}
