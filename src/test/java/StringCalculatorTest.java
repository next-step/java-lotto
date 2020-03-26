import static org.assertj.core.api.Assertions.*;

import calculator.StringCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculatorTest {
    @DisplayName("Null 또는 빈값 입력 테스트")
    @Test
    void input_null_and_empty_test() {
        assertThat(new StringCalculator().splitAndSum(null)).isEqualTo(0);
        assertThat(new StringCalculator().splitAndSum("")).isEqualTo(0);
    }

    @Test
    void 숫자하나입력_테스트() {
        assertThat(new StringCalculator().splitAndSum("1")).isEqualTo(1);
        assertThat(new StringCalculator().splitAndSum("0")).isEqualTo(0);
    }

    @Test
    void comma_split_test() {
        assertThat(new StringCalculator().splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    void comma_colon_split_test() {
        assertThat(new StringCalculator().splitAndSum("1,2:3")).isEqualTo(6);
    }

    @DisplayName("문자열 속에 구분자의 위치를 찾는 단위 테스트")
    @ParameterizedTest()
    @ValueSource(strings = {"//;\n1;2;3"})
    void find_delimeter_test(String data) {
//        String data = "//;\n1;2;3";
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(data);
        assertThat(matcher.find()).isTrue();
        assertThat(matcher.group(1)).isEqualTo(";");
        assertThat(matcher.group(2).split(matcher.group(1))).containsExactly("1", "2", "3");
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3", "1:2,3", "//-\n1:2-3"})
    void custom_split_test(String input) {
        assertThat(new StringCalculator().splitAndSum(input)).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1:-2", "aa","//;\n1-2;a3"})
    void runTimeException_test(String input) {
        assertThatThrownBy(() -> {
                    new StringCalculator().splitAndSum(input);
                }
        ).isInstanceOf(RuntimeException.class);

    }
}
