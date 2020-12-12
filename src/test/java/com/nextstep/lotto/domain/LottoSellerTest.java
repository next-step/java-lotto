package com.nextstep.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoSellerTest {

    @DisplayName("로또 장수 계산")
    @Test
    void countLotto() {
        int price = 14000;
        int count = LottoSeller.count(price);
        assertThat(count).isEqualTo(14);
    }

    @DisplayName("로또 구입")
    @Test
    void buy() {
        Lottos lottos = LottoSeller.buy(10);
        assertThat(lottos.count()).isEqualTo(10);
    }
}
