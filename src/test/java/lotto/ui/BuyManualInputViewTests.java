package lotto.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BuyManualInputViewTests {
    @DisplayName("수동 입력할 로또 수를 입력받아서 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        assertThat(new BuyManualInputView(3)).isNotNull();
    }
}
