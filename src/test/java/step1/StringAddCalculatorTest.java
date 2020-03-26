package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {
    @Test
    @DisplayName("입력받은 문자열이 null일 경우 결과는 0이다.")
    void splitAndSumNull() {
        int result = StringAddCalculator.calculate(null);

        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("입력받은 문자열이 Empty일 경우 결과는 0이다.")
    void splitAndSumEmpty() {
        int result = StringAddCalculator.calculate(" ");

        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 입력했을 경우 결과는 해당 숫자이다.")
    void splitAndSum_숫자하나() throws Exception {
        int result = StringAddCalculator.calculate("2");

        assertThat(result).isEqualTo(2);
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = StringAddCalculator.calculate("1,2");

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringAddCalculator.calculate("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = StringAddCalculator.calculate("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }
}
