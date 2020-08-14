package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

    @Test
    public void splitAndSum_null_또는_빈문자() {
        int result = StringCalculator.splitAndSum(null);
        Assertions.assertThat(result).isEqualTo(0);

        result = StringCalculator.splitAndSum("");
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_숫자하나() throws Exception {
        int result = StringCalculator.splitAndSum("1");
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = StringCalculator.splitAndSum("1,2");
        Assertions.assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringCalculator.splitAndSum("1,2:3");
        Assertions.assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = StringCalculator.splitAndSum("//;\n1;2;3");
        Assertions.assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        Assertions.assertThatThrownBy(() -> StringCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}