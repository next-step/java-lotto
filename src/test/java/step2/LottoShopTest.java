package step2;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.lotto.Lotto;
import step2.shop.LottoShop;
import step2.shop.LottoShopFactory;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("LottoShop")
class LottoShopTest {
    private final List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

    @Test
    @DisplayName("can sell auto number lotto")
    void test1() {
        final LottoShop lottoShopSellsAlwaysSameLottoNumbers = LottoShopFactory.alwaysSame(lottoNumbers);
        final Lotto lotto = lottoShopSellsAlwaysSameLottoNumbers.buyAuto();

        assertThat(lotto).isEqualTo(new Lotto(lottoNumbers));
    }
}