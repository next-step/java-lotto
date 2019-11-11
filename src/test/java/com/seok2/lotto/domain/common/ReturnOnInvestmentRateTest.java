package com.seok2.lotto.domain.common;

import static org.assertj.core.api.Assertions.assertThat;

import com.seok2.lotto.domain.common.ReturnOnInvestmentRate;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class ReturnOnInvestmentRateTest {

    @Test
    void of() {
        assertThat(ReturnOnInvestmentRate.of(1d)).isEqualTo(ReturnOnInvestmentRate.of(new BigDecimal("1.0")));
    }
}