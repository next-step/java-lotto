package calculator.input;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class SymbolTest {

    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "/", "*"})
    void 사칙연산_기호인경우(String str) {
        Symbol symbol = new Symbol(str);

        assertThat(symbol.getSymbol()).isEqualTo(str);
    }

    @Test
    void 사칙연산기호_아닌경우() {
        String str = "!";

        assertThatIllegalArgumentException().isThrownBy(() -> {
            Symbol symbol = new Symbol(str);
            symbol.getSymbol();
        });
    }

}
