package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ParserTest {
    @Test
    public void parser_positive() {
        //given
        List<String> inputStrings = Arrays.asList("1", "2", "3");
        List<Integer> expectResults = Arrays.asList(1, 2, 3);

        //when
        List<Integer> results = Parser.parse(inputStrings);

        //then
        assertThat(results).isEqualTo(expectResults);
    }
}

