package lotto.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringParserTest {

    @Test
    void parseIntList_정상() throws Exception {
        //given
        List<String> input = Arrays.asList("1", "2");

        //when
        List<Integer> result = StringParser.parseIntList(input);

        //then
        assertThat(result).containsExactly(1, 2);
    }

    @Test
    void parseIntList_예외_문자() throws Exception {
        //given
        List<String> input = Arrays.asList("1", "&");

        //when

        //then
        assertThatThrownBy(() -> {
            List<Integer> result = StringParser.parseIntList(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력한 값이 자연수가 아닙니다.");
    }

    @Test
    void parseIntList_예외_음수() throws Exception {
        //given
        List<String> input = Arrays.asList("1", "-3");

        //when

        //then
        assertThatThrownBy(() -> {
            List<Integer> result = StringParser.parseIntList(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력한 값이 자연수가 아닙니다.");
    }
}
