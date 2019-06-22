import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    @DisplayName("문자열 중 숫자가 하나 일때")
    void stringSumSingle(){
        assertThat(calculator.splitAndSum("2")).isEqualTo(2);
    }

    @Test
    @DisplayName("문자열 중 숫자가 아닌 문자 일때")
    void stringSumSingleTextException(){
        assertThatThrownBy(() -> calculator.splitAndSum("#"))
                            .isInstanceOf(RuntimeException.class)
                            .hasMessage("입력 값에 계산 할 수 없는 문자가 포함 되어 있습니다.");
    }

    @Test
    @DisplayName("문자열 중 구분자가 ',' 또는 ';' 일때")
    void stringSumCommaAndsemi(){
        assertThat(calculator.splitAndSum("2,2;3,4")).isEqualTo(11);
    }

    @Test
    @DisplayName("문자열 중 구분자 숫자 이외 다른 문자가 포함 일때")
    void stringSumCommaTextException(){
        assertThatThrownBy(() -> calculator.splitAndSum("2,2,#,4"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("입력 값에 계산 할 수 없는 문자가 포함 되어 있습니다.");
    }

    @Test
    @DisplayName("커스텀 구분자(//와 \\n 사이) 일때")
    void stringSumCustom(){
        assertThat(calculator.splitAndSum("//,\n2,2,3,4")).isEqualTo(11);
    }

    @Test
    @DisplayName("커스텀 구분자 문자열에 음수가 포함 되어 있을때")
    void stringSumCustomNegativeQuantityException(){
        assertThatThrownBy(() -> calculator.splitAndSum("//,\n2,2,-3,4"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("입력 값에 음수가 포함 되어 있습니다.");
    }

    @Test
    @DisplayName("커스텀 구분자 문자열에 숫자 이외에 문자가 포함 되어 있을때")
    void stringSumTextException(){
        assertThatThrownBy(() -> calculator.splitAndSum("//,\n2,2,#,4"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("입력 값에 계산 할 수 없는 문자가 포함 되어 있습니다.");
    }

    @Test
    @DisplayName("문자열이 null 또는 빈문자 일때")
    void stringNull(){
        assertThat(calculator.splitAndSum(null)).isEqualTo(0);
        assertThat(calculator.splitAndSum("")).isEqualTo(0);
    }

}
