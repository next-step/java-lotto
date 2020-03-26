package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
    @Test
    @DisplayName("입력받은 문자열이 null일 경우 결과는 0이다.")
    void splitAndSumNull() {
        int result = StringAddCalculator.caculate(null);

        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("입력받은 문자열이 Empty일 경우 결과는 0이다.")
    void splitAndSumEmpty() {
        int result = StringAddCalculator.caculate(" ");

        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 입력했을 경우 결과는 해당 숫자이다.")
    void splitAndSum_숫자하나() throws Exception {
        int result = StringAddCalculator.caculate("2");

        assertThat(result).isEqualTo(2);
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = StringAddCalculator.caculate("1,2");

        assertThat(result).isEqualTo(3);
    }
}
