import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import stringcaculator.StringCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {
    private StringCalculator cal;

    @BeforeEach
    public void setup() {
        cal = new StringCalculator();
    }

    @Test
    void add_null_또는_빈문자() throws Exception  {
        assertThat(cal.add(null)).isEqualTo(0);
        assertThat(cal.add("")).isEqualTo(0);
    }

    @Test
    void add_숫자하나() throws Exception {
        assertThat(cal.add("1")).isEqualTo(1);
    }

    @Test
    @DisplayName("쉼표 구분자")
    void add_쉼표구분자() throws Exception {
        int result = cal.add("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("쉼표_또는_콜론_구분자")
    void add_쉼표_또는_콜론_구분자() throws Exception {
        assertThat(cal.add("1,2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName("custom_구분자")
    void add_custom_구분자() throws Exception {
        assertThat(cal.add("//;\n1;2;4")).isEqualTo(7);
    }

    @Test
    @DisplayName("add_음수값 ")
    void add_negative() throws Exception {
        assertThrows(RuntimeException.class, () -> {
            cal.add("-1,2,3");
        });
    }

    @Test
    void getTotalSum() {
        String[] inputs ={"1","2","3"};
        int sum = 0;
        for (int i = 0; i < inputs.length; ++i) {

            sum += Integer.parseInt(inputs[i]);
        }
        assertThat(sum).isEqualTo(6);
    }
}
