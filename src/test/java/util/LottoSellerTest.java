package util;


import domain.Lotto;
import domain.Money;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoSellerTest {


    @Test
    @DisplayName("로또를 구매하면 가격에 맞는 로또 개수가 나온다")
    void buyLotto() {
        // given
        Money money = new Money("10000");

        // when
        List<Lotto> lottos = LottoSeller.buyLotto(money);

        // then
        assertThat(lottos).hasSize(10);
    }

    @Test
    @DisplayName("금액이 부족하면 로또를 구매할 수 없다")
    void buyLotto2() {
        // given
        Money money = new Money("900");

        // when
        List<Lotto> lottos = LottoSeller.buyLotto(money);

        // then
        assertThat(lottos).hasSize(0);
    }
}