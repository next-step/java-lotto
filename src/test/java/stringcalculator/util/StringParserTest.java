package stringcalculator.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringParserTest {

    @Test
    void parseInt_정상() throws Exception {
        //given
        String input = "1";

        //when
        int result = StringParser.parseInt(input);

        //then
        assertThat(result).isEqualTo(1);
    }

    @Test
    void parseInt_예외() throws Exception {
        //given
        String input = "&";

        //when

        //then
        assertThatThrownBy(() -> {
            int result = StringParser.parseInt(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력한 값이 정수가 아닙니다.");
    }
}
