package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    @Test
    @DisplayName("1 + 2")
    void calculateTest1() {
        // given
        List<String> strings = Arrays.asList("1", "+", "2");
        // when
        StringCalculator calculator = new StringCalculator(strings);
        // then
        assertThat(calculator.calculate()).isEqualTo(new Number(3));
    }

    @Test
    @DisplayName("1 - 2")
    void calculateTest2() {
        // given
        List<String> strings = Arrays.asList("1", "-", "2");
        // when
        StringCalculator calculator = new StringCalculator(strings);
        // then
        assertThat(calculator.calculate()).isEqualTo(new Number(-1));
    }

    @Test
    @DisplayName("1 + 2 * 4")
    void calculateTest3() {
        // given
        List<String> strings = Arrays.asList("1", "+", "2", "*", "4");
        // when
        StringCalculator calculator = new StringCalculator(strings);
        // then
        assertThat(calculator.calculate()).isEqualTo(new Number(12));
    }

    @Test
    @DisplayName("10 / 2 + 4")
    void calculateTest4() {
        // given
        List<String> strings = Arrays.asList("10", "/", "2", "+", "4");
        // when
        StringCalculator calculator = new StringCalculator(strings);
        // then
        assertThat(calculator.calculate()).isEqualTo(new Number(9));
    }

    @Test
    @DisplayName("12 / 2 * 3")
    void calculateTest5() {
        // given
        List<String> strings = Arrays.asList("12", "/", "2", "*", "3");
        // when
        StringCalculator calculator = new StringCalculator(strings);
        // then
        assertThat(calculator.calculate()).isEqualTo(new Number(18));
    }

}
