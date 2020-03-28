package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private InputView inputView;

    @DisplayName("로또 구입 금액이 최소 금액보다 이하일 경우 예외처리를 해준다")
    @Test
    void validatePurchaseAmount() {
        int purchaseAmount = 500;
        
        assertThatIllegalArgumentException().isThrownBy(() -> {
            inputView = new InputView(purchaseAmount);
        });
    }

    @DisplayName("구입금액에서 구매할 수 있는 구매 수량을 확인한다.")
    @Test
    void getPurchaseCount() {
        int purchaseAmount = 14000;
        inputView = new InputView(purchaseAmount);
        int purchaseCount = inputView.getPurchaseCount();

        assertThat(purchaseCount).isEqualTo(14);
    }
}
