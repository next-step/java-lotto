package calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class SymbolTest {

    @Test
    @DisplayName("산술 기호를 Symbol 로 변환")
    void convert() {
        assertAll(() -> assertThat(Symbol.convert("+")).isEqualTo(Symbol.ADDITION),
                () -> assertThat(Symbol.convert("-")).isEqualTo(Symbol.SUBTRACTION),
                () -> assertThat(Symbol.convert("*")).isEqualTo(Symbol.MULTIPLICATION),
                () -> assertThat(Symbol.convert("/")).isEqualTo(Symbol.DIVISION));
    }

    @ParameterizedTest(name = "산술 기호가 아닌 경우 예외 처리")
    @ValueSource(strings = {".", ",", "0", "a", "!"})
    void convertException(String value) {
        assertThatThrownBy(() -> Symbol.convert(value)).isInstanceOf(IllegalArgumentException.class);
    }

}