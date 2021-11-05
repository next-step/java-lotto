package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("문자열 덧셈 계산기에 대한 테스트")
class StringAddCalculatorTest {

    @Test
    void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculator.sum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.sum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    void splitAndSum_숫자하나() throws Exception {
        int result = StringAddCalculator.sum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void splitAndSum_쉼표구분자() throws Exception {
        int result = StringAddCalculator.sum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringAddCalculator.sum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void splitAndSum_custom_구분자() throws Exception {
        int result = StringAddCalculator.sum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.sum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
