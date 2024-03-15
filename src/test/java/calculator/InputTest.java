package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import caculator.Input;

class InputTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 입력_값이_null이거나_빈_공백_문자일_경우_예외_테스트(final String input) {
        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(() -> new Input(input));
    }

    @Test
    void 리스트의_인덱스에_위치한_문자를_반환한다() {
        // given
        final Input input = new Input("1 + 3");

        // when
        final String result = input.getByIndex(1);

        // then
        assertThat(result).isEqualTo("+");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void Input의_크기보다_작으면_true를_반환한다(final int index) {
        // given
        final Input input = new Input("1 + 3");

        // when
        boolean result = input.isIndexWithinBounds(index);

        // then
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5})
    void Input의_크기보다_작으면_false를_반환한다(final int index) {
        // given
        final Input input = new Input("1 + 3");

        // when
        boolean result = input.isIndexWithinBounds(index);

        // then
        assertThat(result).isFalse();
    }
}
