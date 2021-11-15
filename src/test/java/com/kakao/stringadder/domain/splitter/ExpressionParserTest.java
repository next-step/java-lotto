package com.kakao.stringadder.domain.splitter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ExpressionParserTest {

    @Test
    @DisplayName("커스텀 구분자를 구분하여 문자열을 파싱한다. : regex 문법이 적용될 때도")
    void parse() {
        List<String> parse = ExpressionParser.parse("//+\n1+2+3");
        assertThat(parse).containsExactly("1","2","3");
    }

    @Test
    @DisplayName("기본 구분자로 문자열을 파싱한다.")
    void parseDefault() {
        List<String> parse = ExpressionParser.parse("1,2:3");
        assertThat(parse).containsExactly("1","2","3");
    }
}
