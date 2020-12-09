package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void create_instance() {
        stringCalculator = new StringCalculator();
    }

    static Stream<String> blankStrings() {
        return Stream.of(null, "", "       ");
    }

    @ParameterizedTest
    @DisplayName("빈 문자열 또는 null을 입력하는 경우 결과값으로 0을 반환하는지 테스트")
    @MethodSource("blankStrings")
    void input_blank_or_null(final String input) {
        int result = stringCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName("숫자 하나 입력하는 경우 테스트")
    @CsvSource(value = {"1|1", "132|132"}, delimiter = '|')
    void input_only_one_number(String input, int expected) {
        int result = stringCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("구분자가 쉼표인 경우 테스트")
    @CsvSource(value = {"1,2|3", "3,5|8"}, delimiter = '|')
    void input_split_with_comma(String input, int expected) {
        int result = stringCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("구분자가 쉼표 또는 콜론인 경우 테스트")
    @CsvSource(value = {"1,2:3|6", "10:2,4|16"}, delimiter = '|')
    void input_split_with_comma_or_colon(String input, int expected) {
        int result = stringCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("구분자가 커스텀 구분자인 경우 테스트")
    void input_split_with_custom_delimiter() {
        int result = stringCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);


        result = stringCalculator.splitAndSum("//&\n3&5&7");
        assertThat(result).isEqualTo(15);
    }

    @ParameterizedTest
    @DisplayName("음수 또는 숫자 이외의 값을 전달할 경우 예외 발생 여부 테스트")
    @ValueSource(strings = {"-1,2,3", "1,string,3"})
    void input_negative(String value) {
        assertThatThrownBy(() -> stringCalculator.splitAndSum(value))
                .isInstanceOf(RuntimeException.class).hasMessageContaining(Constants.IS_NOT_VALID_INPUT);
    }
}