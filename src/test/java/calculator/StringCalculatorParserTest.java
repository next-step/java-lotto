package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringCalculatorParserTest {
    @DisplayName("문자열 parse 테스트")
    @Test
    public void parse() throws Exception {
        Assertions.assertThat(StringCalculatorParser.parse("1 + 2 - 3 * 4 / 5").getQueue())
                .containsExactly("1","+","2","-","3","*","4","/","5");

        Assertions.assertThatThrownBy(() -> StringCalculatorParser.parse("a + 2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("Invalid input");

        Assertions.assertThatThrownBy(() -> StringCalculatorParser.parse("1 + 2 - 3 * 4 / 5 ^"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("Invalid input");
    }
}