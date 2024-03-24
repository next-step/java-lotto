package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import lotto.domain.lotto.PurchaseAmount;
import lotto.error.exception.PurchaseAmountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {

    @Test
    @DisplayName("PurchasAmount는 1000원 단위로 생성되어야 한다")
    public void PurchaseAmount_Should_Create_Purchase_Amount_In_Multiple_Of_1000(){
        PurchaseAmount purchaseAmount = new PurchaseAmount(20000);
        assertThat(purchaseAmount.getPurchaseAmount()).isEqualTo(20000);
    }

    @Test
    @DisplayName("PurchasAmount는 1000원 단위로 생성되지 않을 경우 예외가 발생한다")
    public void PurchaseAmount_Should_Throw_Exception_If_Purchase_Amount_Is_Not_Multiple_Of_1000(){
        assertThatThrownBy(() -> new PurchaseAmount(12345))
            .isInstanceOf(PurchaseAmountException.class)
            .hasMessage("구매금액은 1000원 단위로 가능합니다. 입력값: 12,345");
    }
}
