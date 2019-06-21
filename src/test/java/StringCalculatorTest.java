import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    @Test
    @DisplayName("문자열 중 숫자가 하나 일때")
    void stringSumSingle(){
        int sumNumber = StringCalculator.splitAndSum("2");
        assertThat(sumNumber).isEqualTo(2);
    }

    @Test
    @DisplayName("문자열 중 숫자가 아닌 문자 일때")
    void stringSumSingleTextException(){
        assertThatThrownBy(() -> {
            StringCalculator.splitAndSum("#");
        }).isInstanceOf(RuntimeException.class)
        .hasMessage("입력 값에 숫자 아닌 다른 문자가 포함 되어 있습니다.");
    }

    @Test
    @DisplayName("문자열 중 구분자가 ',' 또는 ';' 일때")
    void stringSumCommaAndsemi(){
        int sumNumber = StringCalculator.splitAndSum("2,2;3,4");
        assertThat(sumNumber).isEqualTo(11);
    }

    @Test
    @DisplayName("문자열 중 구분자 숫자 이외 다른 문자가 포함 일때")
    void stringSumCommaTextException(){
        assertThatThrownBy(() -> {
            StringCalculator.splitAndSum("2,2,#,4");
        }).isInstanceOf(RuntimeException.class)
        .hasMessage("입력 값에 계산 할 수 없는 문자가 포함 되어 있습니다.");
    }

    @Test
    @DisplayName("커스텀 구분자(//와 \\n 사이) 일때")
    void stringSumCustom(){
        int sumNumber = StringCalculator.splitAndSum("//,\n2,2,3,4");
        assertThat(sumNumber).isEqualTo(11);
    }

    @Test
    @DisplayName("커스텀 구분자 문자열에 음수가 포함 되어 있을때")
    void stringSumCustomNegativeQuantityException(){
        assertThatThrownBy(() -> {
            StringCalculator.splitAndSum("//,\n2,2,-3,4");
        }).isInstanceOf(RuntimeException.class)
        .hasMessage("입력 값에 음수가 포함 되어 있습니다.");
    }

    @Test
    @DisplayName("커스텀 구분자 문자열에 숫자 이외에 문자가 포함 되어 있을때")
    void stringSumTextException(){
        assertThatThrownBy(() -> {
            StringCalculator.splitAndSum("//,\n2,2,#,4");
        }).isInstanceOf(RuntimeException.class)
        .hasMessage("입력 값에 계산 할 수 없는 문자가 포함 되어 있습니다.");
    }

    @Test
    @DisplayName("문자열이 빈문자열 일때")
    void stringEmpty(){
        int sumNumber = StringCalculator.splitAndSum("");
        assertThat(sumNumber).isEqualTo(0);
    }

    @Test
    @DisplayName("문자열이 null 일때")
    void stringNull(){
        int sumNumber = StringCalculator.splitAndSum(null);
        assertThat(sumNumber).isEqualTo(0);
    }

}
