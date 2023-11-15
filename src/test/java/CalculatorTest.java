import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CalculatorTest {

    @Test
    @DisplayName("연산자와 두 숫자를 입력하면 연산을 수행한다.")
    void 사칙연산_수행(){
        assertAll(
                () -> assertThat(Calculator.operate("+",2, 3)).isEqualTo(5),
                () -> assertThat(Calculator.operate("-",7, 3)).isEqualTo(4),
                () -> assertThat(Calculator.operate("*",2, 3)).isEqualTo(6),
                () -> assertThat(Calculator.operate("/",7, 3)).isEqualTo(2)
        );
    }

    @Test
    @DisplayName("")
    void 문자열_계산결과_반환(){
        String inputString = "2 + 3 * 4 / 2";

        assertThat(Calculator.stringCalculate(inputString)).isEqualTo(10);
    }
}
