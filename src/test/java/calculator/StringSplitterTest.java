package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringSplitterTest {

    @ParameterizedTest
    @ValueSource(strings = { "1", "2", "3"})
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자만 있는 배열을 반환한다")
    void OneNumberJustSplit(String input){
        String[] result = StringSplitter.getSplitInput(input);
        assertThat(result.length).isEqualTo(1);
        assertThat(result[0]).isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(strings = { "1,2", "2,3,4", "1,3,6"})
    @DisplayName("컴마로 input 을 split 한다.")
    void splitByComma(String input){
        String[] result = StringSplitter.getSplitInput(input);
        assertThat(result).isEqualTo(input.split(","));
    }

    @ParameterizedTest
    @ValueSource(strings = { "1,2:3", "1:3,6"})
    @DisplayName("컴마와 콜론으로 input 을 split 한다.")
    void splitByCommaAndColon(String input){
        String[] result = StringSplitter.getSplitInput(input);
        assertThat(result).isEqualTo(input.split(":|,"));
    }

    @Test
    @DisplayName("//”와 “\n” 문자 사이에 커스텀 구분자를 지정해서 input 을 split 한다.")
    void splitByCustomSeparator(){
        String[] result1 = StringSplitter.getSplitInput("//;\n1;2;3");
        assertThat(result1).isEqualTo("1;2;3".split(";"));
        String[] result2 = StringSplitter.getSplitInput("//;\n1;2:3");
        assertThat(result2).isEqualTo("1;2;3".split(";|:|,"));
        String[] result3 = StringSplitter.getSplitInput("//;\n1,3;6");
        assertThat(result3).isEqualTo("1,3;6".split(";|:|,"));
    }

    @ParameterizedTest
    @ValueSource(strings = { "-1,2,3", "-1,2,-3", "1:-12:3"})
    @DisplayName("음수가 있을 경우 RuntimeException 예외가 발생.")
    public void ifThereIsNegativeNumberThrowException(String input) {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(input))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("음수는 입력값에 포함되면 안됩니다.");
    }
}