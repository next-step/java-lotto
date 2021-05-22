package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
    @DisplayName("Null 또는 빈 문자 테스트")
    @ParameterizedTest(name ="{displayName}[{index}] InputText={0} ")
    @NullAndEmptySource
    void splitAndSum_null_또는_빈문자(String text) {
        int result = StringAddCalculator.splitAndSum(text);
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("숫자 하나일 때 테스트")
    @ParameterizedTest(name ="{displayName}[{index}] InputText={0}, ExpectedText={1} ")
    @CsvSource(value = {"1,1", "10,10"}, delimiter = ',')
    void splitAndSum_숫자하나(String text, int expected) throws Exception {
        int result = StringAddCalculator.splitAndSum(text);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("쉼표 구분자 테스트")
    @ParameterizedTest(name ="{displayName}[{index}] InputText={0}, ExpectedText={1} ")
    @CsvSource(value = {"1,2:3", "1,2,3:6"}, delimiter = ':')
    void splitAndSum_쉼표구분자(String text, int expected) throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("쉼표 또는 콜론 구분자 테스트")
    @ParameterizedTest(name ="{displayName}[{index}] InputText={0}, ExpectedText={1} ")
    @CsvSource(value = {"1,2:3 6", "1,2,3:4 10"}, delimiter = ' ')
    void splitAndSum_쉼표_또는_콜론_구분자(String text, int expected) throws Exception {
        int result = StringAddCalculator.splitAndSum(text);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("Custom 구분자 테스트")
    @Test
    void splitAndSum_custom_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("유효성 테스트 (음수여부, 숫자만 포함되어 있는지 여부)")
    @Test
    void splitAndSum_유효성_체크() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("1,-2,3"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("1,ㄱ,3"))
                .isInstanceOf(NumberFormatException.class);
    }
}
