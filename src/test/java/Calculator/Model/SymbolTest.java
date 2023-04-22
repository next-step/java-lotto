package Calculator.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SymbolTest {
    Symbol symbol;

    @BeforeEach
    public void setUp() {
        symbol = new Symbol("+");
    }

    @Test
    @DisplayName("symbol이 아닐 때 IllegalArgumentException")
    public void isSymbol_not_opreator() {
        boolean expected = false;

        boolean actual = symbol.isSymbol("a");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("symbol일 때 return true")
    public void isSymbol_opreator() {
        boolean expected = true;

        boolean actual = symbol.isSymbol("+");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("change symbol success")
    public void changeSymbol_normal() {
        String expected = "-";

        symbol.changeSymbol("-");
        String actual = symbol.currentSymbol();
        assertThat(actual).isEqualTo(expected);
    }

}