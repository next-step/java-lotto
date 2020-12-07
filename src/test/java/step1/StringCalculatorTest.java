package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void create_instance() {
        stringCalculator = new StringCalculator();
    }

    @Test
    @DisplayName("빈 문자열 또는 null을 입력하는 경우 결과값으로 0을 반환하는지 테스트")
    void input_blank_or_null() {
        int result = stringCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = stringCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);

        result = stringCalculator.splitAndSum("  ");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나 입력하는 경우 테스트")
    void input_only_one_number() {
        int result = stringCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);

        result = stringCalculator.splitAndSum("132");
        assertThat(result).isEqualTo(132);
    }

    @Test
    @DisplayName("구분자가 쉼표인 경우 테스트")
    void input_split_with_comma() {
        int result = stringCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);

        result = stringCalculator.splitAndSum("3,5");
        assertThat(result).isEqualTo(8);
    }

    @Test
    @DisplayName("구분자가 쉼표 또는 콜론인 경우 테스트")
    void input_split_with_comma_or_colon() {
        int result = stringCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);

        result = stringCalculator.splitAndSum("10:2,4");
        assertThat(result).isEqualTo(16);
    }

    @Test
    @DisplayName("구분자가 커스텀 구분자인 경우 테스트")
    void input_split_with_custom_delimiter() {
        int result = stringCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);


        result = stringCalculator.splitAndSum("//&\n3&5&7");
        assertThat(result).isEqualTo(15);
    }

    @Test
    @DisplayName("음수를 전달할 경우 예외 발생 여부 테스트")
    void input_negative() {
        assertThatThrownBy(() -> stringCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}