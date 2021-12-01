package com.pollra.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("숫자들 테스트")
class NumbersTest {

    @Test
    @DisplayName("모든 숫자 더하기")
    public void sum() {
        List<Integer> requestNumbers = Arrays.asList(1, 2, 3);
        Numbers numbers = new Numbers(Numbers.toInstance(requestNumbers));

        Number expectedNumber = new Number(6);
        Number resultNumber = numbers.sum();

        assertEquals(expectedNumber, resultNumber);
    }

    @Test
    @DisplayName("숫자들이 같으면 true")
    public void equals() {
        Numbers targetNumbers = new Numbers(Numbers.toInstance(
                Arrays.asList(1, 2, 3)
        ));

        Numbers equalsNumbers = new Numbers(Numbers.toInstance(
                Arrays.asList(1, 2, 3)
        ));

        assertEquals(targetNumbers, equalsNumbers);
    }

    @Test
    @DisplayName("숫자들이 다르면 false")
    public void notEquals() {
        Numbers targetNumbers = new Numbers(Numbers.toInstance(
                Arrays.asList(1, 2, 3)
        ));

        Numbers notEqualsNumbers = new Numbers(Numbers.toInstance(
                Arrays.asList(9, 9)
        ));

        assertNotEquals(targetNumbers, notEqualsNumbers);
    }
}