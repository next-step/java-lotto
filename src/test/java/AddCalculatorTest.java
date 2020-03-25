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
}
