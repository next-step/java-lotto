package com.hskim.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class EarningRateTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        // given
        BigDecimal testValue = BigDecimal.valueOf(200000);
        EarningRate earningRate = new EarningRate(testValue, testValue);

        // when & then
        assertThat(earningRate).isEqualTo(new EarningRate(testValue, testValue));
    }
}
