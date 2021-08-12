package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoShopTest {
    @ParameterizedTest
    @DisplayName("로또 구매 성공 테스트")
    @ValueSource(ints = {1000, 2000, 3000})
    void 로또_구매_성공_테스트(int purchaseAmount) {
        LottoShop lottoShop = new LottoShop(purchaseAmount);
        assertThat(lottoShop.getPurchaseQuantity()).isEqualTo(purchaseAmount / 1000);
    }


}
