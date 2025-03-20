package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoShopTest {

    @ParameterizedTest
    @CsvSource(value = {"15000:15", "1234:1", "10:0", "190000:190"}, delimiter = ':')
    void 구매_횟수(int money, int buyCount) {
        LottoShop lottoShop = new LottoShop();
        assertThat(lottoShop.buyChance(money)).isEqualTo(buyCount);
    }

}
