package lotto.domain;

import lotto.view.InvalidMoneyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMoneyTest {

    @DisplayName("로또 금액은 1000원 이상어야 한다.")
    @Test
    public void lottoMoneyTest() {
        assertThatThrownBy(() -> new LottoMoney(999))
                .isInstanceOf(NotEnoughMoneyException.class)
                .hasMessageContaining("구입 금액은 1000원 이상이어야 합니다");
    }

    @DisplayName("금액을 입력하면 구매할 구매할 수 있는 개수를 구할 수 있다.")
    @Test
    public void getAvailableBuyingCountTest() {
        LottoMoney lottoMoney = new LottoMoney(25009);

        assertThat(lottoMoney.getAvailableBuyingCount()).isEqualTo(25);
    }

    @DisplayName("총 구매 금액을 구할 수 있다.")
    @Test
    public void getPaidTotalTest() {
        LottoMoney lottoMoney = new LottoMoney(25679);

        Double paidTotal = lottoMoney.getPaidTotal();

        assertThat(paidTotal).isEqualTo(25000);
    }

}
