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

    @Test
    @DisplayName("음수 입력 시 RuntimeException")
    public void validNegative() {
        assertThrows(RuntimeException.class
                ,() -> new Number("-1")
        );
    }

    @Test
    @DisplayName("문자 입력 시 RuntimeException")
    public void validCharacter() {
        assertThrows(RuntimeException.class
                ,() -> new Number("뷁")
        );
    }

    @Test
    @DisplayName("숫자일 경우 true")
    public void isNumber() {
        assertFalse(Number.isNumber("A"));
        assertTrue(Number.isNumber("-1"));
        assertTrue(Number.isNumber("1"));
    }

    @Test
    @DisplayName("숫자일 경우 false")
    public void notNumber() {
        assertTrue(Number.notNumber("A"));
        assertFalse(Number.notNumber("-1"));
        assertFalse(Number.notNumber("1"));
    }
}