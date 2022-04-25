package lotto.ui;

import lotto.exception.InvalidPriceException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {
    @Test
    void 음수_입력_테스트() {
        assertThatThrownBy(() -> InputView.validatePrice(-3000))
                .isInstanceOf(InvalidPriceException.class);
    }
}