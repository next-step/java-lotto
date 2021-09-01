package lotto.util;

import static lotto.util.StringUtil.splitByComma;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringUtilTest {

    @ParameterizedTest
    @ValueSource(strings = {"1   ,   3", "   1,3  ", "  1  , 3 "})
    @DisplayName("split ','로 분리된 배열을 반환받을 수 있다.")
    void splitByCommaTest(String input) {

        // when
        String[] result = splitByComma(input);

        // then
        assertThat(result).containsExactly("1", "3");
    }

}