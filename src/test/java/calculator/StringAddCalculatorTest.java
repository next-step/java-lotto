package calculator;

import calculator.StringAddCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
    public static final StringAddCalculator stringAddCalculator = new StringAddCalculator();

    @DisplayName("null 또는 빈문자가 들어오는 경우, 0을 리턴한다")
    @Test
    public void splitAndSum_null_또는_빈문자() {
        int result = stringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = stringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("숫자가 하나인 경우, 자기 자신을 리턴한다")
    @Test
    public void splitAndSum_숫자하나() throws Exception {
        int result = stringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("쉼표구분자가 제대로 작동한다")
    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = stringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("쉼표와 콜론 구분자 모두 작동한다")
    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = stringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("Custom 구분자가 제대로 작동한다")
    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = stringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("음수가 나올 경우, IllegalArgumentException을 던진다")
    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> stringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Custom 구분자가 여러 개일 경우, IllegalArgumentException을 던진다")
    @Test
    public void splitAndSum_numerous_custom_delimiter() throws Exception {
        assertThatThrownBy(() -> stringAddCalculator.splitAndSum("//;a\n1;2;3"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}