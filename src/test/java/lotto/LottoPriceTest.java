package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPriceTest {
    private LottoPrice lottoPrice;
    private Buyer buyer;

    @BeforeEach
    void setUp() {
        lottoPrice = new LottoPrice();
        buyer = new Buyer();
    }

    @DisplayName("로또 1장의 금액은 1000원이다.")
    @Test
    void lottoPriceTest() {
        assertThat(lottoPrice.getLottoPrice()).isEqualTo(1000);
    }

    @DisplayName("로또의 갯수는 구매금액 / 로또금액 이다.")
    @Test
    void buyLottoTest() {
        assertThat(buyer.buyLotto(14000)).isEqualTo(14);
    }
}