package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

public class PurchaseQuantityTest {
    @Test
    @DisplayName("로또 구매 수량에 맞게 수동 로또 갯수 생성을 하는지 확인")
    void 구매수량_갯수생성_확인() {
        PurchaseQuantity purchaseQuantity = new PurchaseQuantity(5);
        PurchaseQuantity manualPurchase = new PurchaseQuantity(6);

        Assertions.assertThatThrownBy(() -> purchaseQuantity.diff(manualPurchase))
                .isInstanceOf(InputMismatchException.class);
    }
}
