import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    private StringCalculator cal;

    @BeforeEach
    public void setup() {
        cal = new StringCalculator();
    }

    @Test
    public void add_null_또는_빈문자() throws Exception  {
        assertThat(cal.add(null)).isEqualTo(0);
        assertThat(cal.add("")).isEqualTo(0);
    }

//    @Test
//    public void add_숫자하나() throws Exception {
//        int result = StringCalculator.splitAndSum("1");
//        assertThat(result).isEqualTo(1);
//    }
//
//    @Test
//    @DisplayName("쉼표 구분자")
//    public void splitAndSum_쉼표구분자() throws Exception {
//        int result = StringCalculator.splitAndSum("1,2");
//        assertThat(result).isEqualTo(1);
//    }
}
