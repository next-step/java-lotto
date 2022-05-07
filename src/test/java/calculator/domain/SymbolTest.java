package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class SymbolTest {

    @DisplayName("symbol 유효성 확인")
    @ParameterizedTest
    @CsvSource(value = {"+:PLUS", "-:MINUS", "*:MULTIPLY", "/:DIVIDE"}, delimiter = ':')
    void classifySymbol(String sign, Symbol expected) {
        assertThat(Symbol.classifySymbol(sign)).isEqualTo(expected);
    }

    @DisplayName("symbol 유효성 확인")
    @ParameterizedTest
    @CsvSource(value = {"isNotSign:PLUS"}, delimiter = ':')
    void classifySymbol_fail(String sign, Symbol expected) {
        assertThatIllegalArgumentException().isThrownBy(() -> Symbol.classifySymbol(sign))
                .withMessageContaining("올바르지 않은 연산자 입니다.");
    }
}
