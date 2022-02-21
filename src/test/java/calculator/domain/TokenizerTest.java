package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class TokenizerTest {

    private Tokenizer tokenizer;

    @DisplayName(value = "빈 문자열 또는 null 값을 입력할 경우 빈 리스트를 반환해야 한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void emptyOrNull(final String text) {
        tokenizer = new Tokenizer(text);
        assertThat(tokenizer.getNumbers().size()).isZero();
    }

    @DisplayName(value = "구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2:3"})
    void colons(final String text) {
        tokenizer = new Tokenizer(text);
        assertThat(tokenizer.getNumbers().size()).isSameAs(3);
    }

    @DisplayName(value = "//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"//o\n1o2o3"})
    void customDelimiter(final String text) {
        tokenizer = new Tokenizer(text);
        assertThat(tokenizer.getNumbers().size()).isSameAs(3);
    }

    @DisplayName(value = "문자열 계산기에 지정된 구분자 외의 문자를 전달하는 경우 RuntimeException 예외 처리를 한다.")
    @Test
    void delimiterValidation() {
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> new Tokenizer("//;\n-1,2;3?9"));
    }
}
