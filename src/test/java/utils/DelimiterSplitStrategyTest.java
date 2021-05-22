package utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DelimiterSplitStrategyTest {

    @Test
    void SplitColonTest(){
        String[] actual = new DelimiterSplitStrategy().split("1:2:3");
        String[] expected = new String[]{"1", "2", "3"};
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void SplitCommaTest(){
        String[] actual = new DelimiterSplitStrategy().split("1,2,3");
        String[] expected = new String[]{"1", "2", "3"};
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void SplitCommaAndColonTest(){
        String[] actual = new DelimiterSplitStrategy().split("1:2,3");
        String[] expected = new String[]{"1", "2", "3"};
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void SplitCustomDelimeterTest(){
        String[] actual = new DelimiterSplitStrategy().split("//;\n1;2;3");
        String[] expected = new String[]{"1", "2", "3"};
        assertThat(actual).isEqualTo(expected);
    }
}