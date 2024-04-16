package lotto.service;

import lotto.constant.ErrorMessage;
import lotto.domain.Lotto;
import lotto.domain.Purchase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ShopTest {
    @Test
    @DisplayName("로또 구매 테스트")
    public void purchaseLottoTest() {
        Purchase purchase = Shop.createLottoPurchase(3000);
        List<String> manualInputLottoNumbers = new ArrayList<>();

        assertThat(Shop.getLottoList(purchase, manualInputLottoNumbers).size()).isEqualTo(3);
    }

    @Test
    @DisplayName("수동 입력 구매 로또가 구매 리스트에 들어가는지 테스트")
    public void purchaseManualLootTest() {
        Purchase purchase = Shop.createLottoPurchase(3000);
        List<String> manualInputLottoNumbers = new ArrayList<>();
        manualInputLottoNumbers.add("3, 4, 5, 6, 7, 8");
        manualInputLottoNumbers.add("23, 39, 1, 10, 42, 7");

        assertThat(Shop.getLottoList(purchase, manualInputLottoNumbers).size()).isEqualTo(3);
        assertThat(Shop.getLottoList(purchase, manualInputLottoNumbers).stream()
                .filter(lotto -> lotto.equals(new Lotto(Arrays.asList(3, 4, 5, 6, 7, 8)))).count()).isEqualTo(1);
        assertThat(Shop.getLottoList(purchase, manualInputLottoNumbers).stream()
                .filter(lotto -> lotto.equals(new Lotto(Arrays.asList(23, 39, 1, 10, 42, 7)))).count()).isEqualTo(1);
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

    @Test
    @DisplayName("수동 구매 숫자 검증 테스트 - 음수 입력")
    public void purchaseManualLottoNegativeError() {
        Purchase purchase = Shop.createLottoPurchase(3000);

        assertThatThrownBy(() -> Shop.validateManualPurchaseCount(purchase, -1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NEGATIVE_MANUAL_PURCHASE_COUNT.getMessage());
    }

    @Test
    @DisplayName("수동 구매 숫자 검증 테스트 - 구매 금액 단위보다 큰 숫자를 입력")
    public void purchaseManualLottoOverError() {
        Purchase purchase = Shop.createLottoPurchase(3000);

        assertThatThrownBy(() -> Shop.validateManualPurchaseCount(purchase, 5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.OVER_WHOLE_PURCHASE_COUNT.getMessage());
    }
}
