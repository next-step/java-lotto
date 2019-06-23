package calculator;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    private StringCalculator cal;

    @Before
    public void setUp() throws Exception {
        cal = new StringCalculator();
    }

    @Test
    public void add_null_또는_빈문자() throws Exception  {
        assertThat(cal.add(null)).isEqualTo(0);
        assertThat(cal.add(" ")).isEqualTo(0);
    }

    @Test
    public void add_숫자하나() throws Exception {
        assertThat(cal.add("1")).isEqualTo(1);
    }
/*
    @Test
    public void add_쉼표구분자() throws Exception {
        assertThat(cal.add("1,2")).isEqualTo(3);
    }

    @Test
    public void add_쉼표_또는_콜론_구분자() throws Exception {
        assertThat(cal.add("1,2:3")).isEqualTo(6);
    }

    @Test
    public void add_custom_구분자() throws Exception {
        assertThat(cal.add("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    public void add_negative() throws Exception {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            cal.add("-1,2,3");
        });
    }
*/
}
