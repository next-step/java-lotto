package me.namuhuchutong.lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoSellerTest {
    
    @DisplayName("로또를 구입할 수 없는 금액일 경우 예외가 발생한다.")
    @Test
    void throw_exception_when_can_buy_lotto() {
        //given
        int givenAmount = 999;
        LottoSeller lottoSeller = new LottoSeller(() -> null);

        //when, then
        assertThatThrownBy(() -> lottoSeller.sellLotto(givenAmount, null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
