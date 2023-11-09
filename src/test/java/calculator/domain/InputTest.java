package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("실패 - 입력 값이 null이거나 빈 공백 문자일 경우 예외가 발생한다.")
    void fail_input_null_or_empty(String text) {
        // given & when & then
        Assertions.assertThatThrownBy(() -> new Input(text))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 값이 null이거나 빈 공백 문자일 수 없습니다.");
    }

    @Test
    @DisplayName("성공 - 사칙연산 기호만 있는 경우 예외가 발생하지 않는다.")
    void success_not_contain_or_empty() {
        // given
        String text = "2 + 3 * 4 / 2";

        // when & then
        assertThat(new Input(text)).as("사칙 연산 기호가 모두 존재하면 예외가 발생하지 않는다.");
    }

    @Test
    @DisplayName("실패 - 사칙연산 기호가 아닌 경우 예외가 발생한다.")
    void fail_not_contain_or_empty() {
        // given
        String text = "2 + 3 * 4 ? 2";

        // when & then
        Assertions.assertThatThrownBy(() -> new Input(text))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사칙연산 기호만 사용 가능합니다.");
    }

    @Test
    @DisplayName("성공 - 문자열을 빈 공백 문자열을 기준으로 분리한다.")
    void success_split_text() {
        // given
        String text = "2 + 3 * 4 / 2";

        Input input = new Input(text);
        List<String> splitedText = input.splitText();

        // when & then
        assertThat(splitedText).hasSize(7);
    }

}
