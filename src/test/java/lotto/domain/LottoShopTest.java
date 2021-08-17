package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoShopTest {
    @ParameterizedTest
    @DisplayName("로또 구매 성공 테스트")
    @ValueSource(ints = {1000, 2000, 3000})
    void 로또_구매_성공_테스트(int purchaseAmount) {
        LottoShop lottoShop = new LottoShop(purchaseAmount, 0);
        assertThat(lottoShop.getPurchaseQuantity()).isEqualTo(purchaseAmount / 1000);
    }

    @Test
    @DisplayName("로또 구매 실패 수동 입력 수량 초과 테스트")
    void 로또_구매_실패_테스트() {
        assertThatThrownBy(() -> new LottoShop(10000, 11))
                .isInstanceOf(RuntimeException.class);
    }


}
