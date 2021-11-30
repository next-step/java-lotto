package com.pollra.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("분리 기호 테스트")
class SeparatorTest {

    @Test
    @DisplayName("같은 값이면 성공")
    public void equals() {
        Separator comma1 = new Separator(",");
        Separator comma2 = new Separator(",");

        assertEquals(comma1, comma2);
    }

    @Test
    @DisplayName("다른 값이면 실패")
    public void notEquals() {
        Separator comma = new Separator(",");
        Separator dot = new Separator(".");

        assertNotEquals(comma, dot);
    }
}