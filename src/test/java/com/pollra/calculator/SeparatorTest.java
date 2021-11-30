package com.pollra.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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

    @Test
    @DisplayName("Separator 가 \":\" 일 때 \"10:2;11\" 입력 시 \"{\"10\", \"2;11\"}\" 리턴")
    public void splitOf() {
        String requestText = "10:2;11";
        Separator colon = new Separator(":");
        List<String> splitResult = colon.splitOf(requestText);
        List<String> expectedSplitResult = Arrays.asList("10", "2;11");

        assertEquals(expectedSplitResult, splitResult);
    }

    @Test
    @DisplayName("Separator 가 \":\" 일 때 \"10:2;11:5\" 입력 시 \"{\"10\", \"2;11\", \"5\"}\" 리턴")
    public void splitOf2() {
        String requestText = "10:2;11:5";
        Separator colon = new Separator(":");
        List<String> splitResult = colon.splitOf(requestText);
        List<String> expectedSplitResult = Arrays.asList("10", "2;11", "5");

        assertEquals(expectedSplitResult, splitResult);
    }
}