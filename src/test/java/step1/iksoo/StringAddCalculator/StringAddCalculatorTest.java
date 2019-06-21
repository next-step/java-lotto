package step1.iksoo.StringAddCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringAddCalculatorTest {
    private StringAddCalculator cal;

    @BeforeEach
    public void setUp() {
        cal = new StringAddCalculator();
    }

    @Test
    public void add_null_또는_빈문자() {
        assertThat(cal.add(null)).isEqualTo(0);
    }

    @Test
    public void add_숫자하나() {
        assertThat(cal.add("1")).isEqualTo(1);
    }

    @Test
    public void add_쉼표구분자() {
        assertThat(cal.add("1,2")).isEqualTo(3);
    }

    @Test
    public void add_쉼표_또는_콜론_구분자() {
        assertThat(cal.add("1,2:3")).isEqualTo(6);
    }

    @Test
    public void add_custom_구분자1() {
        assertThat(cal.add("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    public void add_custom_구분자2() {
        assertThat(cal.add("//~\n3~4~5")).isEqualTo(12);
    }

    @Test
    public void add_negative() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            cal.add("-1,2,3");
        });
    }

    @Test
    public void add_onlyString() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            cal.add("1,가,3");
        });
    }
}
