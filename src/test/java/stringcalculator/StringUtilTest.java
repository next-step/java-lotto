package stringcalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringUtilTest {

    @DisplayName("입력한 문자열들을 공백으로 구분할 수 있다.")
    @Test
    public void splitString_SplitByBlank_MakeArray() {
        String input = "2 + 3 * 4 / 2";
        int inputCount = 7;

        Assertions.assertThat(StringUtil.splitString(input).length)
                .isEqualTo(inputCount);
    }
}
