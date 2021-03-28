package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParserTest {
    @Test
    public void parser_positive() {
        //given
        String[] inputStrings = new String[]{"1", "2", "3"};
        Integer[] expectResults = new Integer[]{1, 2, 3};

        //when
        Integer[] results = Parser.parse(inputStrings);

        //then
        assertThat(results).isEqualTo(expectResults);
    }
}

