package com.pollra.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("숫자 테스트")
class NumberTest {

    @Test
    @DisplayName("더하기")
    public void plus() {
        Number number = new Number(2);
        Number otherNumber = new Number(2);

        Number expectedNumber = new Number(4);

        assertEquals(expectedNumber, number.plus(otherNumber));
    }
}