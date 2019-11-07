package com.seok2.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class AutoTest {

    @Test
    void isAuto() {
        assertThat(Auto.TRUE.isAuto()).isTrue();
        assertThat(Auto.FALSE.isAuto()).isFalse();
    }
}