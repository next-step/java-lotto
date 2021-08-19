package lotto.step3.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LotteriesTest {

    @Test
    @DisplayName("로또 가게에 돈을 지불하면 금액에 맞는 로또 개수를 받는다.")
    void buyLotteries() {
        int money = 5000;
        LottoShop lottoShop = new LottoShop();
        Lotteries lotteries = lottoShop.receiveMoney(5000);
        Assertions.assertThat(lotteries.getLotteries().size()).isEqualTo(5);
    }
}