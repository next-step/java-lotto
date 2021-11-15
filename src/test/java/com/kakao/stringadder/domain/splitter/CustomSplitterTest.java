package com.kakao.stringadder.domain.splitter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CustomSplitterTest {

    @Test
    @DisplayName("자르는 문자를 성정하여 문자열을 나눌 수 있다.")
    void split() {
        CustomSplitter customSplitter = new CustomSplitter("/");
        assertThat(customSplitter.split("1/2/3")).containsExactly("1", "2", "3");
    }
}
