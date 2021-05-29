package io.mwkwon.lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseQuantityTest {


    @Test
    void 구매_수량_원시값_포장_객체_정상_생성_테스트() {
        PurchaseQuantity purchaseQuantity = PurchaseQuantity.create(3);
        assertThat(purchaseQuantity).isEqualTo(PurchaseQuantity.create(3));
    }

    @Test
    void 구매_가능_로또_수량보다_큰_구매_수량_입력시_에러_정상_출력_테스트() {
        PurchaseQuantity purchaseQuantity = PurchaseQuantity.create(11);
        LottoPayment lottoPayment = LottoPayment.create(10000);
        assertThatThrownBy(() -> purchaseQuantity.checkValidPossiblePurchaseQuantity(lottoPayment))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력한 구매금액보다 큰 수량을 입력할 수 없습니다.");
    }

    @Test
    void 음수값_입력_시_에러_정상_출력_테스트() {
        assertThatThrownBy(() -> PurchaseQuantity.create(-1))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("0보다 작은 값은 입력할 수 없습니다.");
    }
}
