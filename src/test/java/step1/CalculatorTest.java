package step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    @Test
    public void calcSum_쉼표구분자() throws Exception {
        int result = Calculator.calcSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void calcSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = Calculator.calcSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void calcSum_custom_구분자() throws Exception {
        int result = Calculator.calcSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void calcSum_negative() throws Exception {
        assertThatThrownBy(() -> Calculator.calcSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
