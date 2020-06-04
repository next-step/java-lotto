package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @Test
    void splitAndSum_null_또는_빈문자() {
        assertThatThrownBy(() -> StringAddCalculator.execute(null))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void splitAndSum_숫자하나() throws Exception {
        StringAddCalculator execute = StringAddCalculator.execute("1");
        int result = execute.sum();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void splitAndSum_쉼표구분자() throws Exception {
        StringAddCalculator execute = StringAddCalculator.execute("1,2");
        int result = execute.sum();
        assertThat(result).isEqualTo(3);
    }

    @Test
    void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        StringAddCalculator execute = StringAddCalculator.execute("1,2:3");
        int result = execute.sum();
        assertThat(result).isEqualTo(6);
    }

    @Test
    void splitAndSum_custom_구분자() throws Exception {
        StringAddCalculator execute = StringAddCalculator.execute("//;\n1;2;3");
        int result = execute.sum();
        assertThat(result).isEqualTo(6);
    }

    @Test
    void splitAndSum_negative() throws Exception {
        StringAddCalculator execute = StringAddCalculator.execute("-1,2,3");
        assertThatThrownBy(() -> execute.sum())
                .isInstanceOf(RuntimeException.class);
    }
}
