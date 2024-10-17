package calculator.calculate;

import calculator.input.Number;
import calculator.input.Numbers;
import calculator.input.Symbol;
import calculator.input.Symbols;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorServiceTest {

    @Test
    void calculate() {
        CalculatorService calculator = new CalculatorService();
        Numbers numbers = new Numbers();
        Symbols symbols = new Symbols();
        numbers.getNumbers().add(new Number("3"));
        numbers.getNumbers().add(new Number("5"));
        numbers.getNumbers().add(new Number("7"));
        numbers.getNumbers().add(new Number("7"));
        numbers.getNumbers().add(new Number("9"));
        symbols.getSymbols().add(new Symbol("+"));
        symbols.getSymbols().add(new Symbol("*"));
        symbols.getSymbols().add(new Symbol("-"));
        symbols.getSymbols().add(new Symbol("/"));
        assertThat(calculator.calculate(numbers, symbols)).isEqualTo(5);
    }
}
