package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringDigitsAdderTest {
    @Test
    @DisplayName("null_또는_빈문자")
    public void calculateTest1() {
        StringDigitsAdder stringDigitsAdder = new StringDigitsAdder(null);

        int result = stringDigitsAdder.calculate();
        assertThat(result).isEqualTo(0);

        StringDigitsAdder stringDigitsAdder2 = new StringDigitsAdder("");

        result = stringDigitsAdder2.calculate();
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자하나")
    public void calculateTest2() {
        StringDigitsAdder stringDigitsAdder = new StringDigitsAdder("1");

        int result = stringDigitsAdder.calculate();
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("쉼표구분자")
    public void calculateTest3() {
        StringDigitsAdder stringDigitsAdder = new StringDigitsAdder("1,2");

        int result = stringDigitsAdder.calculate();
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("쉼표_또는_콜론_구분자")
    public void calculateTest4() {
        StringDigitsAdder stringDigitsAdder = new StringDigitsAdder("1,2:3");

        int result = stringDigitsAdder.calculate();
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("custom_구분자")
    public void calculateTest5() {
        StringDigitsAdder stringDigitsAdder = new StringDigitsAdder("//;\n1;2;3");

        int result = stringDigitsAdder.calculate();
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("negative exception throw")
    public void calculateTest6() {
        StringDigitsAdder stringDigitsAdder = new StringDigitsAdder("-1,2,3");

        assertThatThrownBy(stringDigitsAdder::calculate).isInstanceOf(RuntimeException.class);
    }
}
