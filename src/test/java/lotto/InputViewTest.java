package lotto;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @DisplayName("로또 구입 금액이 최소 금액보다 이하일 경우 예외처리를 해준다")
    @Test
    void validatePurchaseAmount() {
        int purchaseAmount = 500;

        assertThatIllegalArgumentException().isThrownBy(() -> {
            inputView.validatePurchaseAmount(purchaseAmount);
        });
    }
}
