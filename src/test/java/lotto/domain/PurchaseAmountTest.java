package lotto.domain;

import lotto.exceptions.InvalidLottoAmountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseAmountTest {

    @Test
    @DisplayName("로또 수량 계산 시 로또 금액의 배수가 아닌 값을 입력하면 InvalidLottoAmountException 예외를 던진다.")
    void invalid_amount() {
        assertThatThrownBy(() -> new PurchaseAmount(13200))
                .isInstanceOf(InvalidLottoAmountException.class);
    }

    @Test
    @DisplayName("로또 수량 계산 시 로또 금액으로 음수를 입력하면 InvalidLottoAmountException 예외를 던진다.")
    void invalid_negative_amount() {
        assertThatThrownBy(() -> new PurchaseAmount(13200))
                .isInstanceOf(InvalidLottoAmountException.class);
    }

    @Test
    @DisplayName("로또 금액으로 14000원을 입력 시 10장이 반환된다.")
    void calculate_lotto_quantity() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(14000);

        assertThat(purchaseAmount.calculateLottoQuantity()).isEqualTo(14);
    }
}