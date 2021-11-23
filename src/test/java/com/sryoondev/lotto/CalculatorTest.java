package com.sryoondev.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력값이 빈 경우 0 리턴")
    void testCalculator_빈문자열(String text) {
        assertThat(StringCalculator.splitAndSum(text)).isEqualTo(0);
    }

    @Test
    void testCalculator_숫자하나() {
        int result = StringCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("쉼표를 구분자로 갖는 문자열을 전달하는 경우 구분자를 기준으로 분리된 각 숫자의 합을 반환")
    void testCalculator_쉼표구분자() {
        int result = StringCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("콜론를 구분자로 갖는 문자열을 전달하는 경우 구분자를 기준으로 분리된 각 숫자의 합을 반환")
    void testCalculator_콜론구분자() {
        int result = StringCalculator.splitAndSum("1:2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("쉼표와 콜론을 함께 사용한 문자열 테스트")
    void testCalculator_쉼표콜론구분자() {
        int result = StringCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자 테스트")
    void testCalculator_커스텀구분자() {
        int result = StringCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수를 전달할 경우 예외처리")
    void testCalculator_음수전달() {
        assertThatThrownBy(() -> StringCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
