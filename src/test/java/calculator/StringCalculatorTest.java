package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    public void 음수_포함_문자_Exception_Test() throws Exception {
        assertThatThrownBy(() -> calculator.calculate("-1,3,2"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 문자열에_커스텀구분자_적용_Test() {
        calculator.calculate("//;\n1;2;3");
        assertThat(calculator.delimiter()).isEqualTo(";");
    }

    @Test
    void 문자열에서_숫자문자열_추출_Test() {
        calculator.calculate("//;\n1;2;3");
        assertThat(calculator.numbersString()).isEqualTo("1;2;3");

        calculator.calculate("1,2");
        assertThat(calculator.numbersString()).isEqualTo("1,2");

        calculator.calculate("3");
        assertThat(calculator.numbersString()).isEqualTo("3");
    }

    @Test
    void 숫자문자열에서_숫자들_분해_Test() {
        calculator.calculate("1,2");
        assertThat(calculator.numbers().toStringList()).containsExactly("1", "2");

        calculator.calculate("1:2,3");
        assertThat(calculator.numbers().toStringList()).containsExactly("1", "2", "3");

        calculator.calculate("//;\n1;2;3");
        assertThat(calculator.numbers().toStringList()).containsExactly("1", "2", "3");
    }

    @Test
    void 분해한_숫자들_합산_Test() {
        assertThat(calculator.calculate("1:2,3")).isEqualTo(6);

        assertThat(calculator.calculate("//;\n6;5;4")).isEqualTo(15);
    }

    @Test
    void 유효한_한개_숫자_Test() {
        assertThat(calculator.calculate("2")).isEqualTo(2);
    }

    @DisplayName("커스텀 구분자로 정상동작 하는지 테스트 한다.")
    @Test
    void customDelimiterTest() {
        assertThat(calculator.calculate("//;\n1;3;4")).isEqualTo(8);
    }

    // 이하, 제공된 테스트케이스

    @Test
    public void splitAndSum_null_또는_빈문자() {
        int result = calculator.calculate(null);
        assertThat(result).isEqualTo(0);

        result = calculator.calculate("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_숫자하나() throws Exception {
        int result = calculator.calculate("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = calculator.calculate("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = calculator.calculate("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = calculator.calculate("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> calculator.calculate("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
