package com.nextstep.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoSellerTest {

    @DisplayName("로또 장수 계산")
    @Test
    void countLotto() {
        int price = 14000;
        int count = LottoSeller.count(price);
        assertThat(count).isEqualTo(14);
    }

    @DisplayName("로또 발급 기능")
    @Test
    void buyLotto() {
        Lottos lottos = LottoSeller.buy(10);
        assertThat(lottos.size()).isEqualTo(10);
    }
}
