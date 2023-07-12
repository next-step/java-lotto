package lotto;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import lotto.domain.TextParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TextParserTest {

    @DisplayName("숫자가 아니면 예외가 발생한다")
    @ValueSource(strings = {"a", "가나다"})
    @ParameterizedTest()
    void 로또_번호_검증_실패_문자(String value) {
        assertThatExceptionOfType(NumberFormatException.class)
            .isThrownBy(() -> new TextParser(value));
    }

    @DisplayName("null이면 예외가 발생한다")
    @Test()
    void 로또_번호_검증_실패_null() {
        String value = null;

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new TextParser(value))
            .withMessage("값을 입력해야 합니다");
    }

    @DisplayName("비어있거나 공백인 경우 에러가 발생한다")
    @ValueSource(strings = {"", " ", "  "})
    @ParameterizedTest()
    void 로또_번호_검증_실패_공백(String value) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new TextParser(value))
            .withMessage("값을 입력해야 합니다");
    }
}
