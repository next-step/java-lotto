package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class SplitUtilTest {

    @DisplayName("숫자 하나를 입력시 해당 숫자 반환")
    @Test
    void singleNumber() {
        String input = "1";
        String[] result = SplitUtil.splitByDelimiter(input);
        assertThat(result).hasSize(1);
        assertThat(result[0]).isEqualTo(input);
    }

    @DisplayName("기본 구분자(,:)로 구분하여 리스트 생성")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1:2:3", "1:2,3"})
    void splitByDefaultDelimiter(String input) {
        String[] result = SplitUtil.splitByDelimiter(input);
        assertThat(result).hasSize(3);
        for (String n : result) {
            assertThat(n).isIn(Arrays.asList("1", "2", "3"));
        }
    }

    @DisplayName("커스텀 구분자로 구분하여 리스트 생성")
    @Test
    void splitByCustomDelimiter() {
        String input = "//;\n1;2;3";
        String[] result = SplitUtil.splitByDelimiter(input);
        assertThat(result).hasSize(3);
        for (String n : result) {
            assertThat(n).isIn(Arrays.asList("1", "2", "3"));
        }
    }

}