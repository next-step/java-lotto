package step1;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
    private StringAddCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringAddCalculator();
    }

    @Test
    @DisplayName("입력받은 문자열이 null일 경우 결과는 0이다.")
    void splitAndSumNull() {
        int result = calculator.calculate(null);

        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("입력받은 문자열이 Empty일 경우 결과는 0이다.")
    void splitAndSumEmpty() {
        int result = calculator.calculate(" ");

        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 입력했을 경우 결과는 해당 숫자이다.")
    void splitAndSum_숫자하나() throws Exception {
        int result = calculator.calculate("2");

        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("쉼표 구분자로 구분하여 더해준다.")
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = calculator.calculate("1,2");

        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("쉼표와 콜론으로 구분하여 더해준다.")
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = calculator.calculate("1,2:3");

        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("Custom 구분자의 경우에는 \\와 \n 사이에 있는 구분자로 구분하여 더해준다.")
    public void splitAndSum_custom_구분자() throws Exception {
        int result = calculator.calculate("//;\n1;2;3");

        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("파싱된 숫자가 음수일 경우 예외 처리를 수행한다.")
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> calculator.calculate("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
