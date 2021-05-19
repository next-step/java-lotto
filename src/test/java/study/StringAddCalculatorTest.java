package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @DisplayName("null 또는 빈 문자를 넣으면 0 이 리턴 되는지")
    @ParameterizedTest
    @NullAndEmptySource
    public void splitAndSum_null_or_empty(String input) {
        //given
        int expected = 0;
        int result;

        //when
        result = StringAddCalculator.splitAndSum(input);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("String 1 을 넣으면 int 1 이 리턴 되는지")
    public void splitAndSum_only_one() {
        //given
        String input = "1";
        int expected = 1;
        int result;

        //when
        result = StringAddCalculator.splitAndSum(input);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("1,2를 넣었을 때 ,(쉼표)로 구분자를 정해서 3이 리턴되는지")
    public void splitAndSum_comma_separator() {
        //given
        String input = "1,2";
        int expected = 3;
        int result;

        //when
        result = StringAddCalculator.splitAndSum(input);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("1,2:3을 넣었을 때 ,(쉼표)와 :(콜론)으로 구분자를 정해서 6이 리턴되는지")
    public void splitAndSum_comma_or_colon_separator() {
        //given
        String input = "1,2:3";
        int expected = 6;
        int result;

        //when
        result = StringAddCalculator.splitAndSum(input);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("// 와 \\n 사이로 들어오는 값을 구분자로 정해서 합계가 잘 나오는지")
    public void splitAndSum_custom_separator() {
        //given
        String input = "//;\n1;2;3";
        int expected = 6;
        int result;

        //when
        result = StringAddCalculator.splitAndSum(input);

        //then¬
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("음수로 값이 들어올 때 RuntimeException 에러가 나는지")
    public void splitAndSum_negative() {
        //given
        String input = "-1,2,3";

        //when
        //then
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(input))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContainingAll("최소값 보다 작은 값은 더할 수 없습니다.");
    }
}