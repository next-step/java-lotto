package lotto.step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringAddCalculatorTest {

    @Test
    @DisplayName("빈 문자열이나 null을 입력했을 경우 0 리턴 테스트")
    void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    public void splitAndSum_숫자하나() throws Exception {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다.")
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. ")
    public void splitAndSum_negative()  {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("숫자 이외의 값이 전달 될 경우 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1,adf,2", "adb,1"})
    void calculateFailByInvalidString(String expression) {
        assertThatIllegalArgumentException().isThrownBy(() -> StringAddCalculator.splitAndSum(expression));
    }

    @DisplayName(" “//”와 “\\n” 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3", "//a\n1a2a3", "//-\n1-2-3"})
    void customDelimiterCalculate(String expression) {
        int actual = StringAddCalculator.splitAndSum(expression);

        assertThat(actual).isEqualTo(6);
    }

    @DisplayName("문자열 계산기 정상 작동")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3=6", "1,2:3=6"}, delimiter = '=')
    void calculate(String expression, int expected) {

        int actual = StringAddCalculator.splitAndSum(expression);
        assertThat(actual).isEqualTo(expected);
    }
}
