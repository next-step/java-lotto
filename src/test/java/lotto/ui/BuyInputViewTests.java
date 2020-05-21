package lotto.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BuyInputViewTests {
    @DisplayName("금액을 입력받고 보여줄 수 있다.")
    @Test
    void getValueAndSeeTest() {
        BuyInputView buyInputView = new BuyInputView(14000);
        assertThat(buyInputView.getMoney()).isEqualTo(14000);
    }

    @DisplayName("금액은 1000원 단위여야 한다.")
    @ParameterizedTest
    @ValueSource(longs = {100L, 112356L})
    void getValueFailWithInvalidMoney(long invalidMoney) {
        assertThatThrownBy(() -> new BuyInputView(invalidMoney)).isInstanceOf(IllegalArgumentException.class);
    }
}
