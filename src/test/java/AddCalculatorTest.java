import static org.assertj.core.api.Assertions.*;

import calculator.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddCalculatorTest {
    @DisplayName("Null 또는 빈값 입력 테스트")
    @Test
    void input_null_and_empty_test() {
        assertThat(new Calculator().sum(null)).isEqualTo(0);
        assertThat(new Calculator().sum("")).isEqualTo(0);
    }

    @Test
    void 숫자하나입력_테스트() {
        assertThat(new Calculator().sum("1")).isEqualTo(1);
        assertThat(new Calculator().sum("0")).isEqualTo(0);
    }
    @Test
    void comma_split_test(){
        assertThat(new Calculator().sum("1,2")).isEqualTo(3);
    }

    @Test
    void comma_colon_split_test() {
        assertThat(new Calculator().sum("1,2:3")).isEqualTo(6);
    }

    @DisplayName("문자열 속에 구분자의 위치를 찾는 단위 테스트")
    @Test
    void find_delimeter_test() {
        String data = "//;\n1;2;3";
        Matcher macher = Pattern.compile("//(.)\n(.*)").matcher(data);
        assertThat(macher.find()).isTrue();
        assertThat(macher.group(1)).isEqualTo(";");
        assertThat(macher.group(2).split(macher.group(1))).containsExactly("1","2","3");
    }

    @Test
    void custom_split_test() {
        String data = "//;\n1;2;3";
        assertThat(new Calculator().sum("//;\n1;2;3")).isEqualTo(6);
    }
}
