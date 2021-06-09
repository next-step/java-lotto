package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoPriceTest {
    private LottoPrice lottoPrice;
    private Buyer buyer;

    @BeforeEach
    void setUp() {
        lottoPrice = new LottoPrice();
        buyer = new Buyer(14000);
    }

    @DisplayName("로또 1장의 금액은 1000원이다.")
    @Test
    void lottoPriceTest() {
        assertThat(lottoPrice.getLottoPrice().intValue()).isEqualTo(1000);
    }

    @DisplayName("로또의 갯수는 구매금액 / 로또금액 이다.")
    @Test
    void buyLottoTest() {
        assertThat(buyer.buyLotto()).isEqualTo(14);
    }

    @DisplayName("구입금액은 1000원 이상이어야 한다.")
    @Test
    void validatePurchaseTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            buyer = new Buyer(900);
        });
    }
}
