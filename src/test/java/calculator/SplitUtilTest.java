package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SplitUtilTest {

    @DisplayName("Default 구분자(쉼표,콜론)로 문자열 Split하는지 테스트")
    @ParameterizedTest(name = "{displayName} ==> input : {0}")
    @CsvSource({"1","2","3"})
    void split_by_default_delimiter(String input){
        //Given
        String str = "1:2,3";

        //When
        Operands operands = new Operands(SplitUtil.splitByDelimiter(str));

        //Then
        assertThat(operands.contains(new Operand(input))).isTrue();
    }

    @DisplayName("Custom 구분자로 문자열 Split하는지 테스트")
    @ParameterizedTest(name = "{displayName} ==> input : {0}")
    @CsvSource({"1","2","3"})
    void split_by_custom_delimiter(String input){
        //Given
        String str = "//a\n1a2a3";

        //When
        Operands operands = new Operands(SplitUtil.splitByDelimiter(str));

        //Then
        assertThat(operands.contains(new Operand(input))).isTrue();
    }

    @DisplayName("Default+Custom 구분자로 문자열 Split하는지 테스트")
    @ParameterizedTest(name = "{displayName} ==> input : {0}")
    @CsvSource({"1","2","3","4"})
    void split_by_default_and_custom_delimiter(String input){
        //Given
        String str = "//a\n1:2a3,4";

        //When
        Operands operands = new Operands(SplitUtil.splitByDelimiter(str));

        //Then
        assertThat(operands.contains(new Operand(input))).isTrue();
    }

    @DisplayName("Custom 구분자가 여러 개인 경우, IllegalArgumentException을 반환하는지 테스트")
    @Test
    void numerous_custom_delimiter(){
        //Given
        String input = "//a;\n1;2a3";

        //When+Then
        assertThatThrownBy(() -> SplitUtil.splitByDelimiter(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
