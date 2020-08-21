package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoSellerTest {
    @DisplayName("판매자 인스턴스 생성")
    @Test
    void newSeller() {
        //given
        int money = 1000;

        //when
        LottoSeller lottoSeller = new LottoSeller(money);

        //then
        assertThat(lottoSeller).isNotNull();
    }

    @DisplayName("최소 구입금액 이하인 경우 에러를 발생시킨다.")
    @Test
    void newSellerWithWrongMoney() {
        //given
        int money = 999;

        //when, then
        assertThatIllegalArgumentException().isThrownBy(()-> new LottoSeller(money))
                .withMessage("구입금액이 부족합니다.");
    }


}
