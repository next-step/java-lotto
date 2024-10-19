package calculator.calculate;

import calculator.input.Numbers;
import calculator.input.Symbols;

public class CalculatorService {

    public CalculatorService() {
    }

    public int calculate(Numbers numbers, Symbols symbols) {
        int value = numbers.getFirst();

        for (int i = 0; i < symbols.getSize(); i++) {
            Arithmetic arithmetic = Arithmetic.fromSymbol(symbols.findBySymbol(i));
            value = arithmetic.apply(value, numbers.findByNumber(i + 1));
        }

        return value;
    }

}
