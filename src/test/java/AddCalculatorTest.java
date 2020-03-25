import static org.assertj.core.api.Assertions.*;

import calculator.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AddCalculatorTest {
    @DisplayName("Null 또는 빈값 입력 테스트")
    @Test
    void input_null_and_empty_test() {
        assertThat(new Calculator("").getResult()).isEqualTo(0);
        assertThat(new Calculator(null).getResult()).isEqualTo(0);
    }

    @Test
    void 숫자하나입력_테스트() {
        assertThat(new Calculator("1").getResult()).isEqualTo(1);
        assertThat(new Calculator("0").getResult()).isEqualTo(0);
    }
    @Test
    void comma_split_test(){
        assertThat(new Calculator("1,2").getResult()).isEqualTo(3);
    }

    @Test
    void comma_colon_split_test() {
        assertThat(new Calculator("1,2:3").getResult()).isEqualTo(6);
    }

    @DisplayName("문자열 속에 구분자의 위치를 찾는 단위 테스트")
    @Test
    void find_delimeter_test() {
        String data = "//;\n1;2;3";
        assertThat(data.substring(data.lastIndexOf("/")+1,data.indexOf("\n"))).isEqualTo(";");
    }

    @Test
    void custom_split_test() {
        String data = "//;\n1;2;3";
        assertThat(new Calculator("//;\n1;2;3").getResult()).isEqualTo(6);
    }
}
