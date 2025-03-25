package calculator.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class InputViewTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "1 + 2", "1 - 2", "1 * 2", "1 / 2", "1 + 2 - 3 * 4 / 5"})
    @DisplayName("입력 문자열은 숫자, 사칙 연산, 공백만 입력한다")
    void inputCorrectText(String text) {
        System.setIn(new ByteArrayInputStream(text.getBytes()));
        InputView inputView = new InputView();

        assertThat(inputView.input()).isEqualTo(text);
    }

    @ParameterizedTest
    @ValueSource(strings = {"x + 2", "(1 + 2)"})
    @DisplayName("입력 문자열에 숫자, 사칙 연산, 공백만 입력한다")
    void inputWrongText(String text) {
        System.setIn(new ByteArrayInputStream(text.getBytes()));
        InputView inputView = new InputView();

        assertThatThrownBy(inputView::input)
                .isInstanceOf(IllegalArgumentException.class);
    }

}