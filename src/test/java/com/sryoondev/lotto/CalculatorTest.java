package com.sryoondev.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    @DisplayName("쉼표를 구분자로 갖는 문자열을 전달하는 경우 구분자를 기준으로 분리된 각 숫자의 합을 반환")
    void testCalculator() {
        int result = StringCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);

        result = StringCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }
}
