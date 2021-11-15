package com.kakao.stringadder.domain.splitter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultSplitterTest {

    @Test
    @DisplayName(",와 : 으로 문자열을 나눈다.")
    void split() {
        String input = "1:2,3";
        DefaultSplitter defaultSplitter = new DefaultSplitter();
        assertThat(defaultSplitter.split(input)).containsExactly("1","2","3");
    }
}
