package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoShopTest {

    private LottoShop lottoShop;

    @BeforeEach
    void setUp() {
        lottoShop = new LottoShop();
    }

    @DisplayName("구입 금액에 해당하는 만큼 로또 구매")
    @ParameterizedTest
    @CsvSource(value = {"14000:14", "1000:1", "1500:1", "9999:9"}, delimiter = ':')
    void purchaseCountTest(int input, int expected) {
        PurchaseMoney purchaseMoney = new PurchaseMoney(input);

        Lottos lottos = lottoShop.purchase(purchaseMoney);

        assertThat(lottos.getCount()).isEqualTo(expected);
    }
}
