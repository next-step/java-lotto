package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SymbolsTest {

    @Test
    @DisplayName("식에서 연산자만 list에 넣는다.")
    void create_Symbols_test() {
        Symbols symbols = Symbols.create(new String[]{"1", "+", "3", "-", "4"});
        assertThat(symbols.getSymbols().contains("1")).isFalse();
        assertThat(symbols.getSymbols().contains("3")).isFalse();
        assertThat(symbols.getSymbols().contains("4")).isFalse();
        assertThat(symbols.getSymbols().get(0).getSymbol()).isEqualTo("+");
        assertThat(symbols.getSymbols().get(1).getSymbol()).isEqualTo("-");
    }
}
