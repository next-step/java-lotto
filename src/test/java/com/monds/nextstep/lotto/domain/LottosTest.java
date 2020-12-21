package com.monds.nextstep.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @Test
    @DisplayName("로또 생성")
    void testCreateLottos() {
        Lottos lottos = new Lottos(1);
        assertThat(lottos.size()).isEqualTo(1);
    }
}
