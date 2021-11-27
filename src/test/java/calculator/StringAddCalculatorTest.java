package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
    @Test
    public void splitAndSum_null() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_빈문자() {
        int result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_숫자하나() {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void splitAndSum_문자_하나() {
        assertThatThrownBy(() -> {
            StringAddCalculator.splitAndSum("하나");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void splitAndSum_문자_쉼표구분자() {
        assertThatThrownBy(() -> {
            StringAddCalculator.splitAndSum("하나,둘");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void splitAndSum_문자_custom_구분자() {
        assertThatThrownBy(() -> {
            int result = StringAddCalculator.splitAndSum("//;\n하나;둘;셋");
            assertThat(result).isEqualTo(6);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
