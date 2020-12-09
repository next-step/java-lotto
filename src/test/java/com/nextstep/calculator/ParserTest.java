package com.nextstep.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ParserTest {
    @DisplayName("쉼표, 콜론 기본 구분자")
    @ParameterizedTest
    @CsvSource({"'1,2,3',3", "'1,2:3',3", "'1:2:3:4',4"})
    void split(String source, int expected) {
        Splitter splitter = Parser.parse(source);
        String[] array = splitter.split();
        assertThat(array.length).isEqualTo(expected);
    }

    @DisplayName("커스텀 구분자 테스트")
    @ParameterizedTest
    @CsvSource({"'//;\n1;2;3',3", "'//#\n1#2#3',3"})
    void customSplit(String source, int expected) {
        Splitter splitter = Parser.parse(source);
        String[] array = splitter.split();
        assertThat(array.length).isEqualTo(expected);
    }
}
