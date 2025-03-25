package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class WinnerNumberInputTest {
    @ParameterizedTest(name = "숫자를 6개 입력하지 않으면 예외를 던진다. 입력: {0}")
    @ValueSource(strings = {
            "1,2,3,4,5",
            "1,2,3,4,5,6,7"
    })
    void nullInputTest(String input) {
        assertThatThrownBy(() -> WinnerNumberInput.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "숫자가 아닌 것을 입력하면 예외를 던진다. 입력: {0}")
    @ValueSource(strings = {
            "1,2,3,4,5,ㅈ",
            "1,2,3,4,5,!"
    })
    void notNumberInputTest(String input) {
        assertThatThrownBy(() -> WinnerNumberInput.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "중복되는 숫자를 입력하면 예외를 던진다. 입력: {0}")
    @ValueSource(strings = {
            "1,2,3,4,5,5"
    })
    void outOfRangeInputTest(String input) {
        assertThatThrownBy(() -> WinnerNumberInput.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
