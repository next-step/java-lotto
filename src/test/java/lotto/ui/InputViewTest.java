package lotto.ui;

import lotto.exception.InvalidCountOfManualLotto;
import lotto.exception.InvalidNegativeNumberException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {
    @Test
    void 음수_입력_테스트() {
        assertThatThrownBy(() -> InputView.validateNegativeNumber("금액 혹은 갯수", -3000))
                .isInstanceOf(InvalidNegativeNumberException.class);
    }

    @Test
    void 수동입력개수가_총개수_넘어서는_경우_테스트() {
        assertThatThrownBy(() -> InputView.validateCountOfManualLotto( 9800, 10))
                .isInstanceOf(InvalidCountOfManualLotto.class);
    }
}