package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class InputViewTest {

    InputView inputView = new InputView();

    @Test
    @DisplayName(value = "로또 최소 구매 금액 검사")
    void test1() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            inputView.validPrice(900);
        });
    }
}