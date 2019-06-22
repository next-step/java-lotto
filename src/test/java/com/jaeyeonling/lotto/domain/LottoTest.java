package com.jaeyeonling.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @DisplayName("Lotto 생성")
    @Test
    void create() {
        Lotto lotto = new Lotto();
        assertThat(lotto).isNotNull();
    }

}
