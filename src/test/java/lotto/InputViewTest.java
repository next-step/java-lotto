package lotto;

import lotto.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputViewTest {

    @ParameterizedTest
    @DisplayName("구입 금액은 숫자만 입력 가능하다.")
    @ValueSource(strings = {"abc", "가나다", "ㄱㄴㄷ", "ABC", "@#$", "3%2"})
    public void 숫자_유효성_확인(String input) {
        assertThatThrownBy(() -> InputView.validate(input))
                .isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("숫자만 입력 가능합니다.");
    }

    @Test
    @DisplayName("구입 금액은 양수만 입력 가능하다.")
    public void 양수_확인() {
        assertThatThrownBy(() -> InputView.validate("-1000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("양수만 입력 가능합니다.");
    }
}
