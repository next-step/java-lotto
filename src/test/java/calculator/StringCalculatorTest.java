package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {
    private StringCalculator calculator;

    @BeforeEach
    void beforeEach() {
        calculator = new StringCalculator();
    }

    @Test
    void 문자열_0_또는_null_Test() {
        assertThat(calculator.isNullOrZero("0")).isTrue();
        assertThat(calculator.isNullOrZero(null)).isTrue();
    }

    @Test
    void 문자열에_커스텀구분자_적용_Test() {
        calculator.putNumberString("//;\n1;2;3");
        assertThat(calculator.delimiter()).isEqualTo(";");
    }

    @Test
    void 문자열에서_숫자문자열_추출_Test() {
        calculator.putNumberString("//;\n1;2;3");
        assertThat(calculator.numbersString()).isEqualTo("1;2;3");

        calculator.putNumberString("1,2");
        assertThat(calculator.numbersString()).isEqualTo("1,2");

        calculator.putNumberString("3");
        assertThat(calculator.numbersString()).isEqualTo("3");
    }

    @Test
    void 숫자문자열에서_숫자들_분해_Test() {
        calculator.putNumberString("1,2");
        assertThat(calculator.numbers().toStringList()).containsExactly("1", "2");

        calculator.putNumberString("1:2,3");
        assertThat(calculator.numbers().toStringList()).containsExactly("1", "2", "3");

        calculator.putNumberString("//;\n1;2;3");
        assertThat(calculator.numbers().toStringList()).containsExactly("1", "2", "3");
    }

    @Test
    void 분해한_숫자들_합산_Test() {
        calculator.putNumberString("1:2,3");
        assertThat(calculator.calculate()).isEqualTo(6);

        calculator.putNumberString("//;\n6;5;4");
        assertThat(calculator.calculate()).isEqualTo(15);
    }
}
