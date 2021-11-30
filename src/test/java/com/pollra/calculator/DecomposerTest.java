package com.pollra.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("분해자 테스트")
class DecomposerTest {

    @Test
    @DisplayName("\"//;\\\\n1;2;3\" 입력 시 Numbers 로 변환")
    public void decompose() {
        Decomposer decomposer = new Decomposer();
        Numbers resultNumbers = decomposer.decompose("//;\\\\n1;2;3");

        Numbers expectedNumbers = new Numbers(Numbers.toInstance(
                Arrays.asList(1, 2, 3)
        ));
        assertEquals(expectedNumbers, resultNumbers);
    }

    @Test
    @DisplayName("\"1;2;3\" 입력 시 Numbers 로 변환")
    public void notDecompose() {
        Decomposer decomposer = new Decomposer();
        Numbers resultNumbers = decomposer.decompose("1;2;3");

        Numbers expectedNumbers = new Numbers(Numbers.toInstance(
                Arrays.asList(1, 2, 3)
        ));
        assertEquals(expectedNumbers, resultNumbers);
    }
}