import calculator.StringAddCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringAddCalculatorTest {
    private StringAddCalculator cal;

    @BeforeEach
    public void setup() {
        cal = new StringAddCalculator();
    }

    @Test
    public void testAddNullOrEmpty() throws Exception  {
        assertThat(cal.add(null)).isEqualTo(0);
        assertThat(cal.add("")).isEqualTo(0);
    }

    @Test
    public void testAddCommaDelimiter() throws Exception {
        assertThat(cal.add("1,2")).isEqualTo(3);
    }

    @Test
    public void testAddCommaOrColonDelimiter() throws Exception {
        assertThat(cal.add("1,2:3")).isEqualTo(6);
    }

    @Test
    public void testAddCustomDelimiter() throws Exception {
        assertThat(cal.add("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    public void testNegative() throws Exception {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            cal.add("-1,2,3");
        });
    }
}