package com.jaeyeonling.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoneyTest {

    @DisplayName("생성")
    @Test
    void create() {
        final Money money = new Money();
        assertThat(money).isNotNull();
    }
}
