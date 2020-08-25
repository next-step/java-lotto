package calc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {

    @Test
    @DisplayName("쉼표(,) 또는 콜론(:)을 구분자 합 테스트")
    public void sumTest(){
        //given
        String str = "1,2:3";

        //when then
        assertThat(StringAddCalculator.splitAndSum(str)).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자를 지정 하여 합 테스트")
    public void customDelimTest(){
        //given
        String str = "//;\n1;2;3";

        //when then
        assertThat(StringAddCalculator.splitAndSum(str)).isEqualTo(6);
    }

    @ParameterizedTest
    @DisplayName("숫자가 아닌 문자, 음수 입력 시 에러 발생 테스트")
    @ValueSource(strings = {"//;\n1;2;3;#", "//;\n-1;-2;-3"})
    public void invalidInputTest1(String input){
        assertThatIllegalArgumentException().isThrownBy(()-> StringAddCalculator.splitAndSum(input));
    }

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

}