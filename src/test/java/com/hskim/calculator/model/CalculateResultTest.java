package com.hskim.calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by hs kim on 2020/08/14
 */
public class CalculateResultTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        // given
        CalculateResult calculateResult = new CalculateResult(5);

        // when & then
        assertThat(calculateResult).isEqualTo(new CalculateResult(5));
    }

    @DisplayName("createResultString() 테스트")
    @ParameterizedTest
    @ValueSource(ints = {3, 5, 7, 9, 11, 15})
    void createResultString_성공(int result) {
        // given
        CalculateResult calculateResult = new CalculateResult(result);
        String expected = String.valueOf(result);

        // when
        String resultString = calculateResult.createResultString();

        // then
        assertThat(resultString).isEqualTo(expected);
    }
}
