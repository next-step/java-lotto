package adder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringAdderTest {

    private final StringAdder stringAdder = new StringAdder();

    @ParameterizedTest(name = "문자열 덧셈 | {arguments}")
    @CsvSource(value = {"12|12", "1,2|3", "1,2:3|6"}, delimiter = '|')
    public void splitAndSum(String input, int expected) {
        // given

        // when
        int result = stringAdder.splitAndSum(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("커스텀 구분자 문자열 덧셈")
    public void customSplitAndSum() {
        // given
        String input = "//;\n1;2;3;4";
        int expected = 10;

        // when
        int result = stringAdder.splitAndSum(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest(name = "공백이 포함된 문자열 덧셈 | {arguments}")
    @CsvSource(value = {"::,7,:|7", "1,2,,3|6", "1,2:3:|6"}, delimiter = '|')
    public void blankInput(String input, int expected) {
        // given

        // when
        int result = stringAdder.splitAndSum(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("커스텀 구분자 공백이 포함된 문자열 덧셈")
    public void customBlankInput() {
        // given
        String input = "//;\n;1;2;3;4;;";
        int expected = 10;

        // when
        int result = stringAdder.splitAndSum(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

}