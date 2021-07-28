package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringAddCalculatorTest {

    @Test
    void create() {
        StringAddCalculator stringAddCalculator = new StringAddCalculator();
        assertThat(stringAddCalculator).isInstanceOf(StringAddCalculator.class);
    }

    @DisplayName("null 또는 빈 문자일 경우 0을 반환")
    @Test
    void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 5, 9})
    void splitAndSum_숫자하나() {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("숫자 두개를 컴마(,)을 구분자로 입력할 경우 두 숫자의 합을 반환")
    @ParameterizedTest
    @CsvSource(value = {"7,8,5$20", "5,5$10", "10,20$30"}, delimiter = '$')
    void splitAndSum_쉼표구분자(String input, int output) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(output);
    }

    @DisplayName("숫자 두개를 콜론(:)을 구분자로 입력할 경우 두 숫자의 합을 반환")
    @ParameterizedTest
    @CsvSource(value = {"7:8:5$20", "3:2,5$10","5:5$10", "10:20$30"}, delimiter = '$')
    void splitAndSum_쉼표_또는_콜론_구분자(String input, int output) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(output);
    }

    @DisplayName("\"//\"와 \"\\n\" 문자 사이에 커스텀 구분자를 지정하여 사용")
    @Test
    void splitAndSum_custom_구분자() {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
        result = StringAddCalculator.splitAndSum("//&\n4&6&8");
        assertThat(result).isEqualTo(18);
    }

    /*
    @Test
    void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
    */

}