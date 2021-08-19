package lotto.step4;

import lotto.step4.domain.LottoShop;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoShopTest {

    @Test
    @DisplayName("구입 금액이 6000원 ,로또 수동 3장이면 로또 자동은 3장이다. ")
    void receiveMoney(){
        LottoShop lottoShop = new LottoShop(3);
        Assertions.assertThat(lottoShop.receiveMoney(6000)).isEqualTo(3);
    }

    @Test
    @DisplayName("구입 금액이 6000원 ,로또 수동 6장이면 로또 자동은 0장이다. ")
    void receiveMoney2(){
        LottoShop lottoShop = new LottoShop(6);
        Assertions.assertThat(lottoShop.receiveMoney(6000)).isEqualTo(0);
    }

    @Test
    @DisplayName("구입 금액이 6000원 ,로또 수동 0장이면 로또 자동은 6장이다. ")
    void receiveMoney3(){
        LottoShop lottoShop = new LottoShop(0);
        Assertions.assertThat(lottoShop.receiveMoney(6000)).isEqualTo(6);
    }

}