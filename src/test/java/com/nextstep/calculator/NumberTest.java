package com.nextstep.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberTest {
    @DisplayName("문자열을 인자로 받아 값 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        String value = "12930";

        Number number = new Number(value);
        
        assertThat(number).isNotNull();
        assertThat(number).isEqualTo(new Number(value));
    }
}
