package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SymbolsTest {

    @Test
    @DisplayName("식에서 연산자만 list에 넣는다.")
    void create_Symbols_test() {
        Symbols symbols = Symbols.create(new String[]{"1", "+", "3", "-", "4"});

        assertThat(symbols.of(0)).isEqualTo("+");
        assertThat(symbols.of(1)).isEqualTo("-");
    }
}
