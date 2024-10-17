package calculator.calculate;

import calculator.input.Numbers;
import calculator.input.Symbols;
public class CalculatorService {

    public CalculatorService() {
    }

    public int calculate(Numbers numbers, Symbols symbols) {
        int value = numbers.getNumbers().get(0).getNumber();

        for (int i = 0; i < symbols.getSymbols().size(); i++) {
            Arithmetic arithmetic = Arithmetic.fromSymbol(symbols.getSymbols().get(i).getSymbol());
            value = arithmetic.apply(value, numbers.getNumbers().get(i + 1).getNumber());
        }

        return value;
    }

}
