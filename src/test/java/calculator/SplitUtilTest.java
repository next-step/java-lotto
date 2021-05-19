package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class SplitUtilTest {

    @DisplayName("쉼표나 콜론으로 문자열 Split하는지 테스트")
    @Test
    void split_by_default_delimiter(){
        //Given
        String input = "1:2,3";

        //When
        Operands operands = SplitUtil.splitByDelimiter(input);

        //Then
        assertThat(operands.size()).isEqualTo(3);
    }
}
