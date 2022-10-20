package domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"7", "9999", "-3", "32"})
    public void 정수_문자_입력_expect_Success(String text) {
        Number number = new Number(text);
        number.equals(new Number(text));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0.7", "1.246", "1/6"})
    public void 정수_아닌_문자_expect_IllegalArgumentException(String text) {
        assertThatThrownBy(() -> new Number(text))
                .isInstanceOf(NumberFormatException.class);

    }

    @ParameterizedTest
    @ValueSource(strings = {"*"})
    public void 숫자_아닌_문자_expect_NumberFormatException(String text) {
        assertThatThrownBy(() -> new Number(text))
                .isInstanceOf(NumberFormatException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "   "})
    public void 공백문자열_expect_NumberFormatException(String text) {
        assertThatThrownBy(() -> new Number(text))
                .isInstanceOf(NumberFormatException.class);
    }

}
