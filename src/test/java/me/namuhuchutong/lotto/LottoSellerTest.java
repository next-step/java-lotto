package me.namuhuchutong.lotto;

import static org.assertj.core.api.Assertions.*;

import me.namuhuchutong.lotto.domain.LottoSeller;
import me.namuhuchutong.lotto.dto.UserInputInformation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoSellerTest {
    
    @DisplayName("로또를 구입할 수 없는 금액일 경우 예외가 발생한다.")
    @Test
    void throw_exception_when_can_not_buy_lotto() {
        //given
        int givenAmount = 999;
        String givenNumbers = "1, 2, 3, 4, 5, 6";
        LottoSeller lottoSeller = new LottoSeller(() -> null);
        UserInputInformation information = new UserInputInformation(givenAmount, givenNumbers);

        //when, then
        assertThatThrownBy(() -> lottoSeller.sellLotto(information))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
