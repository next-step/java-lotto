package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class InputItemTypeTest {
    @ParameterizedTest
    @CsvSource(value = {"+:OPERATOR", "1:NUMBER", " :SPACE", "@:UNKNOWN"}, delimiter = ':', ignoreLeadingAndTrailingWhitespace = false)
    void 입력항목_타입_구하기_검증(String item, InputItemType expected) {
        // when
        InputItemType inputItemType = InputItemType.from(item);

        // then
        Assertions.assertThat(inputItemType).isEqualTo(expected);
    }
}
