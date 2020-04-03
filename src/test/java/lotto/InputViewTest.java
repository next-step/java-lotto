package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private static InputView inputView = InputView.getInputView();

    @DisplayName("로또 구입 금액이 최소 금액보다 이하일 경우 예외처리를 해준다")
    @Test
    void validatePurchaseAmount() {
        int purchaseAmount = 500;

        assertThatIllegalArgumentException().isThrownBy(() -> {
            inputView.validatePurchaseAmount(purchaseAmount);
        });
    }

    @DisplayName("구입금액에서 구매할 수 있는 구매 수량을 확인한다.")
    @Test
    void getPurchaseCount() {
        int purchaseAmount = 14000;
        int purchaseCount = inputView.getPurchaseCount(purchaseAmount);

        assertThat(purchaseCount).isEqualTo(14);
    }

    @DisplayName("수동으로 구매 할 로또수 구매금액보다 클 시 예외처리를 해준다")
    @Test
    void validateManualCount() {

        assertThatIllegalArgumentException().isThrownBy(() -> {
            inputView.validateManualCount(inputView.getPurchaseCount(15000), 16);
        });
    }

    @DisplayName("자동개수가 몇개인지 카운트를 센다")
    @Test
    void getCount() {
        assertThat(inputView.getAutomaticCount(15, 13)).isEqualTo(2);
    }
}
