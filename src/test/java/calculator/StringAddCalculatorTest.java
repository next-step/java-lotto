package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @Test
    @DisplayName("splitAndSum 함수에 null or 빈 문자를 넣으면 0을 반환한다.")
    public void splitAndSum_null_또는_빈문자() {
        assertThat(StringAddCalculator.splitAndSum(null)).isEqualTo(0);
        assertThat(StringAddCalculator.splitAndSum("")).isEqualTo(0);
    }

    @Test
    @DisplayName("splitAndSum 함수에 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    public void splitAndSum_숫자하나() {
        assertThat(StringAddCalculator.splitAndSum("1")).isEqualTo(1);
    }

    @Test
    @DisplayName("splitAndSum 함수에 숫자 두개를 컴파(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    public void splitAndSum_쉼표구분자(){
        assertThat(StringAddCalculator.splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    @DisplayName("splitAndSum 함수에 구분자를 컴파(,) 이외에 콜론(:)을 사용할 수 있다.")
    public void splitAndSum_쉼표_또는_콜론_구분자(){
        assertThat(StringAddCalculator.splitAndSum("1,2:3")).isEqualTo(6);
    }

    @ParameterizedTest
    @DisplayName("splitAndSum 함수에 '//'와 '\n' 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    @ValueSource(strings = {"//;\n1;2;3", "//-\n1-2-3"})
    public void splitAndSum_custom_구분자(String customSeparator){
        assertThat(StringAddCalculator.splitAndSum(customSeparator)).isEqualTo(6);
        assertThat(StringAddCalculator.splitAndSum(customSeparator)).isEqualTo(6);
    }

    @Test
    @DisplayName("splitAndSum 함수에 음수를 전달하면 예외가 발생한다.")
    public void splitAndSum_negative(){
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("음수가 존재합니다.");
    }
}