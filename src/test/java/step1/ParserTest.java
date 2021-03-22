package step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ParserTest {
    @Test
    public void parser_positive() {
        //given
        String[] inputStrings = new String[]{"1","2","3"};
        Integer[] expectResults = new Integer[]{1,2,3};

        //when
        Integer[] results = Parser.parser(inputStrings);


        //then
        assertThat(results).isEqualTo(expectResults);
    }

    @Test
    public void parser_negative() {
        //given
        String[] inputStrings = new String[]{"-1","2","3"};

        //when

        //then
        assertThatThrownBy(() -> Parser.parser(inputStrings))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void parser_other() {
        //given
        String[] inputStrings = new String[]{"a","b","3"};

        //when

        //then
        assertThatThrownBy(() -> Parser.parser(inputStrings))
                .isInstanceOf(RuntimeException.class);
    }



}
