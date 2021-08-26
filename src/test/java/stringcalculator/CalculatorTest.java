package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    @DisplayName("일반 구분자(, 혹은 ;)를 사용한 계산식=> 1,2:3은 6을 반환한다.")
    void inputHavingNormalDelimiterTest() {
        Calculator cal = new Calculator();
        WholeNumber actual = cal.calculate("1,2:3");
        WholeNumber expected = new WholeNumber(6);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("커스텀 구분자(//과 \\n 사이에 들어간 문자.)를 사용한 계산식=> //;\\n1;2;3은 6을 반환한다.")
    void inputHavingCustomizedDelimiterTest() {
        Calculator cal = new Calculator();
        WholeNumber actual = cal.calculate("//;\n1;2;3");
        WholeNumber expected = new WholeNumber(6);
        assertThat(actual).isEqualTo(expected);
    }
}
