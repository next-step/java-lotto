package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.LottoMoney.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMoneyTest {

    @DisplayName("로또 구매 금액 계산")
    @Test
    void createLottoMoney() {
        int purchaseMoney = 13500;
        LottoMoney lottoMoney = new LottoMoney(purchaseMoney);
        assertThat(lottoMoney.getValue()).isEqualTo(purchaseMoney - (purchaseMoney % LOTTO_PRICE));
    }

    @DisplayName("로또 가격보다 적을 시 예외 발생")
    @Test
    void notEnoughMoney() {
        int notEnoughMoney = -1;
        assertThatThrownBy(() -> new LottoMoney(notEnoughMoney))
                .isInstanceOf(IllegalArgumentException.class);
    }

}