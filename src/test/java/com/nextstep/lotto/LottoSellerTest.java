package com.nextstep.lotto;

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
}
