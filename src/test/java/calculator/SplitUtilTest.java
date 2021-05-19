package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class SplitUtilTest {

    @DisplayName("Default 구분자(쉼표,콜론)로 문자열 Split하는지 테스트")
    @Test
    void split_by_default_delimiter(){
        //Given
        String input = "1:2,3";

        //When
        Operands operands = SplitUtil.splitByDelimiter(input);

        //Then
        assertThat(operands.size()).isEqualTo(3);
    }

    @DisplayName("Custom 구분자로 문자열 Split하는지 테스트")
    @Test
    void split_by_custom_delimiter(){
        //Given
        String input = "//a\n1a2a3";

        //When
        Operands operands = SplitUtil.splitByDelimiter(input);

        //Then
        assertThat(operands.size()).isEqualTo(3);
    }

    @DisplayName("Default+Custom 구분자로 문자열 Split하는지 테스트")
    @Test
    void split_by_default_and_custom_delimiter(){
        //Given
        String input = "//a\n1:2a3,4";

        //When
        Operands operands = SplitUtil.splitByDelimiter(input);

        //Then
        assertThat(operands.size()).isEqualTo(4);
    }
}
