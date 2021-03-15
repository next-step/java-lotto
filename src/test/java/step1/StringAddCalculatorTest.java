package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorTest {
    private StringAddCalculator stringAddCalculator;

    public StringAddCalculatorTest() {
        stringAddCalculator = new StringAddCalculator();
    }

    @DisplayName("null_또는_빈문자는 결과값이 0이다.")
    @Test
    void calculate() {
        int result = stringAddCalculator.calculate(null);
        assertThat(result).isEqualTo(0);

        result = stringAddCalculator.calculate("");
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("숫자 한개일때 테스트")
    @Test
    void calculate_숫자하나() {
        int result = stringAddCalculator.calculate("1");
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("숫자 두개일때 테스트")
    @Test
    void calculate_쉼표구분자() {
        int result = stringAddCalculator.calculate("1,2");
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("표_또는_콜론_구분자 테스트")
    @Test
    void calculate_쉼표_또는_콜론_구분자() {
        int result = stringAddCalculator.calculate("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("custom_구분자 테스트")
    @Test
    void calculate_custom_구분자() {
        int result = stringAddCalculator.calculate("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("음수 테스트")
    @Test
    void calculate_negative() {
        assertThatThrownBy(() -> stringAddCalculator.calculate("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("덧셈 테스트")
    @Test
    void sum() {
        String[] stringNumbers = {"1","2","3"};
        int result = stringAddCalculator.sum(stringNumbers);
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("분할 테스트")
    @Test
    void split() {
        String input = "1,2,3,4";
        String[] split = stringAddCalculator.split(input);
        assertThat(split).contains("1","2","3","4");
    }
}