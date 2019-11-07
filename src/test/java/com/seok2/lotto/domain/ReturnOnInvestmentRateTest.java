package com.seok2.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;

class ReturnOnInvestmentRateTest {

    @Test
    void of() {
        assertThat(ReturnOnInvestmentRate.of(1d)).isEqualTo(ReturnOnInvestmentRate.of(BigDecimal.ONE));
    }
}