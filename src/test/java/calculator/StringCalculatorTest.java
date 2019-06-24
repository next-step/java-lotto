package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringCalculatorTest {
    private StringCalculator cal;

    @BeforeEach
    void setUp() {
        cal = new StringCalculator();
    }

    @Test
    void add_null_또는_빈문자() {
        assertThat(cal.add(null)).isEqualTo(0);
        assertThat(cal.add(" ")).isEqualTo(0);
    }

    @Test
    void add_숫자하나() {
        assertThat(cal.add("1")).isEqualTo(1);
    }

    @Test
    void add_쉼표구분자() {
        assertThat(cal.add("1,2")).isEqualTo(3);
    }

    @Test
    void add_쉼표_또는_콜론_구분자() {
        assertThat(cal.add("1,2:3")).isEqualTo(6);
    }

    @Test
    void add_custom_구분자() {
        assertThat(cal.add("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    void add_negative() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            cal.add("-1,2,3");
        });
    }

    @Test
    void add_not_number() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            cal.add("aa;a,2,3");
        });
    }
}
