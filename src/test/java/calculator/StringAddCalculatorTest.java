package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringAddCalculatorTest {

    @Test
    @DisplayName("빈 문자열 또는 null일 경우 0 리턴")
    public void checkNullAndEmpty() throws Exception {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 리턴")
    public void checkOneLetter() throws Exception {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자 두 개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 리턴")
    public void checkComma() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }
    
    @Test
    @DisplayName("콜론(:)도 구분자로 포함할 경우")
    public void checkColon() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }
    
    @Test
    @DisplayName("\"//\"와 \"\\n\" 문자 사이에 커스텀 구분자를 지정할 경우")
    public void checkCustomDelimiter() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }
}