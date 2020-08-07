package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static calculator.StringAddCalculator.ERROR_MSG_NEGATIVE_VALUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringAddCalculatorTest {
    @DisplayName("null 또는 빈문자")
    @Test
    void splitAndSum_null_or_emptyStr() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum(" ");
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("숫자하나")
    @Test
    void splitAndSum_singleNum() {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("쉼표 구분자")
    @ParameterizedTest
    @CsvSource(value = {"1,2=3","1,2,3=6", "1,2,3,4=10"},delimiter = '=')
    public void splitAndSum_commaSeparator(String text, int answer) {
        int calculatedResult = StringAddCalculator.splitAndSum(text);
        assertThat(calculatedResult).isEqualTo(answer);
    }

    @DisplayName("쉼표 또는 콜론 구분자")
    @ParameterizedTest
    @CsvSource(value = {"1:2=3","1,2:3=6", "1,2:3:4=10"},delimiter = '=')
    public void splitAndSum_commaOrColonSeparator(String text, int answer) {
        int calculatedResult = StringAddCalculator.splitAndSum(text);
        assertThat(calculatedResult).isEqualTo(answer);
    }

    @DisplayName("기본구분자(쉼표,콜론)이 아닌 문자가 들어온 경우 0리턴")
    @ParameterizedTest
    @CsvSource(value = {"1-2=0","1a2b3=0", "a13413aaaa=0"},delimiter = '=')
    public void splitAndSum_unexpectedSeparator(String text, int answer) {
        int calculatedResult = StringAddCalculator.splitAndSum(text);
        assertThat(calculatedResult).isEqualTo(answer);
    }

    @DisplayName("사용자 정의 구분자")
    @Test
    public void splitAndSum_customSeparator() {
        assertThat(StringAddCalculator.splitAndSum("//;\n1;2")).isEqualTo(3);
        assertThat(StringAddCalculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
        assertThat(StringAddCalculator.splitAndSum("//;\n1;2;3;4")).isEqualTo(10);
    }

    @DisplayName("잘못된 사용자 정의 구분자")
    @Test
    public void splitAndSum_unexpectedcustomSeparator() {
        assertThat(StringAddCalculator.splitAndSum("///\n1/2")).isEqualTo(0);
        assertThat(StringAddCalculator.splitAndSum("//;\n1-2-3")).isEqualTo(0);
        assertThat(StringAddCalculator.splitAndSum("//---\n1;2;3;4")).isEqualTo(0);
    }

    @DisplayName("숫자에 음수가 전달될 경우 예외 발생")
    @Test
    public void splitAndSum_negative() {
        assertThatIllegalArgumentException().isThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3")).withMessage(ERROR_MSG_NEGATIVE_VALUE);
        assertThatIllegalArgumentException().isThrownBy(() -> StringAddCalculator.splitAndSum("//;\n1;2;-3;4")).withMessage(ERROR_MSG_NEGATIVE_VALUE);
    }
}
