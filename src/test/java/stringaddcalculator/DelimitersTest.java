package stringaddcalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class DelimitersTest {

    @Test
    void create(){
        // given, when
        Delimiters delimiters = new Delimiters();

        //then
        Assertions.assertThat(delimiters.getDelimiters()).isEqualTo(Arrays.asList(",", ":"));
    }

    @Test
    void addDelimiter(){
        // given
        Delimiters delimiters = new Delimiters();

        // when
        delimiters.addDelimiter(";");

        // then
        Assertions.assertThat(delimiters.getDelimiters()).isEqualTo(Arrays.asList(",", ":", ";"));
    }

    @Test
    void regex(){
        // given
        Delimiters delimiters = new Delimiters();

        // when
        delimiters.addDelimiter(";");
        String regex = delimiters.regex();

        // then
        Assertions.assertThat(regex).isEqualTo(",|:|;");
    }
}
