package step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringDigitsAdderTest {
    @Test
    public void splitAndSum_null_또는_빈문자() {
        StringDigitsAdder stringDigitsAdder = new StringDigitsAdder(null);

        int result = stringDigitsAdder.calculate();
        assertThat(result).isEqualTo(0);

        StringDigitsAdder stringDigitsAdder2 = new StringDigitsAdder("");

        result = stringDigitsAdder2.calculate();
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_숫자하나() {
        StringDigitsAdder stringDigitsAdder = new StringDigitsAdder("1");

        int result = stringDigitsAdder.calculate();
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() {
        StringDigitsAdder stringDigitsAdder = new StringDigitsAdder("1,2");

        int result = stringDigitsAdder.calculate();
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        StringDigitsAdder stringDigitsAdder = new StringDigitsAdder("1,2:3");

        int result = stringDigitsAdder.calculate();
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        StringDigitsAdder stringDigitsAdder = new StringDigitsAdder("//;\n1;2;3");

        int result = stringDigitsAdder.calculate();
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        StringDigitsAdder stringDigitsAdder = new StringDigitsAdder("//;\n1;2;3");

        assertThatThrownBy(() -> stringDigitsAdder.calculate())
                .isInstanceOf(RuntimeException.class);
    }
}
