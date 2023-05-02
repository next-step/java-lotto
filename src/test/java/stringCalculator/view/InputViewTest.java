package stringCalculator.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class InputViewTest {

    @Test
    @DisplayName(value = "입력 값이 null 이거나 공백일 경우 IllegalArgumentException 발생 하는지 테스트")
    void test1() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            InputView.validInputString("");
        });
    }
}