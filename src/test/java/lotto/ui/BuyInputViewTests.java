package lotto.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BuyInputViewTests {
    @DisplayName("금액을 입력받고 보여줄 수 있다.")
    @Test
    void getValueAndSeeTest() {
        BuyInputView buyInputView = new BuyInputView(14000);
        assertThat(buyInputView.getMoney()).isEqualTo(14000);
    }
}
