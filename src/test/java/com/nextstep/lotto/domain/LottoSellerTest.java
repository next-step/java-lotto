package com.nextstep.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoSellerTest {
    @DisplayName("로또 개수 계산")
    @Test
    void count() {
        int count = LottoSeller.count(10000);
        assertThat(count).isEqualTo(10);
    }

    @DisplayName("로또 구입")
    @Test
    void buy() {
        List<Lotto> manualLottos = Arrays.asList(new Lotto(Arrays.asList(1,2,3,4,5,6)));
        Lottos lottos = LottoSeller.buy(manualLottos, 9);
        assertThat(lottos.count()).isEqualTo(10);
    }
}
