package edu.nextstep.stringaddcalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class DelimitersTest {

    @Test
    void create(){
        // given, when
        Delimiters delimiters = Delimiters.create();

        //then
        assertThat(delimiters.regex()).isEqualTo(",|:");
    }

    @Test
    void regex(){
        // given
        String customDelimiter = ";";

        // when
        Delimiters delimiters = Delimiters.create(customDelimiter);
        String delimitersRegex = delimiters.regex();

        // then
        assertThat(delimitersRegex).isEqualTo(",|:|;");
    }

}
