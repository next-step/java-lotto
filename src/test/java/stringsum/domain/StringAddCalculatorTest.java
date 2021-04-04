package stringsum.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class StringAddCalculatorTest {

    @Test
    public void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_숫자하나() throws Exception {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }


    @Test
    @DisplayName("숫자만 남아있는지 확인")
    public void remainedNumbersTest(){
        String inputText = "1:2,3:4";
        String[] result = StringAddCalculator.remainedNumbers(inputText);

        assertThat(result).containsExactly("1","2","3","4");
    }

    @Test
    @DisplayName("custom한 문자로 숫자만 남아있는지 확인")
    public void remainedNumbersTestByCustom(){
        String inputText = "//;\n1;2;3;4";
        String[] result = StringAddCalculator.remainedNumbers(inputText);

        assertThat(result).containsExactly("1","2","3","4");
    }

    @Test
    @DisplayName("숫자 더하기")
    public void sumTest(){
        String inputText = "//;\n1;2;3;4";
        String[] numbers = StringAddCalculator.remainedNumbers(inputText);
        int result = StringAddCalculator.sum(numbers);
        assertThat(result).isEqualTo(10);
    }


}