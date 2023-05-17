package util;


import domain.Lotto;
import domain.Money;
import domain.Number;
import dto.LottoBuyResult;
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
        LottoBuyResult result = LottoSeller.buyLotto(money);

        // then
        assertThat(result.getLottos()).hasSize(10);
    }

    @Test
    @DisplayName("금액이 부족하면 로또를 구매할 수 없다")
    void buyLotto2() {
        // given
        Money money = new Money("900");

        // when
        LottoBuyResult result = LottoSeller.buyLotto(money);

        // then
        assertThat(result.getLottos()).hasSize(0);
    }

    @Test
    @DisplayName("수동으로 구매한 로또 개수만큼 금액이 차감된다")
    void payManualLottoPrice() {
        // given
        Money money = new Money("10000");
        Number manualLottoCount = new Number(3);

        // when
        Money result = LottoSeller.payManualLottoPrice(money, manualLottoCount);

        // then
        assertThat(result.value()).isEqualTo(7000);
    }
}