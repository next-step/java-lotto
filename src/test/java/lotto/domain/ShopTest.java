package lotto.domain;

import lotto.constant.ErrorMessage;
import lotto.service.Shop;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ShopTest {
    @Test
    @DisplayName("로또 구매 테스트")
    public void purchaseLottoTest() {
        Purchase purchase = Shop.createLottoPurchase(3000);
        List<String> manualInputLottoNumbers = new ArrayList<>();

        assertThat(Shop.purchaseLotto(purchase, manualInputLottoNumbers).size()).isEqualTo(3);
    }

    @Test
    @DisplayName("로또 구매 금액 오류 테스트 - 음수 입력")
    public void purchaseLottoNegativeNumError() {
        assertThatThrownBy(() -> Shop.createLottoPurchase(-1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NEGATIVE_PURCHASE_PRICE_ERROR.getMessage());
    }

    @Test
    @DisplayName("로또 구매 금액 오류 테스트 - 1000 단위 예외 입력")
    public void purchaseLotto1000UnitErrorTest() {
        assertThatThrownBy(() -> Shop.createLottoPurchase(3500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.PURCHASE_SINGULAR_PRICE_ERROR.getMessage());
    }
}
