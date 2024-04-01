package calculator.domain;


import calculator.enums.OperatorEnum;

public class Calculator {

    private final Numbers numbers;
    private final Symbols symbols;

    public Calculator(Numbers numbers, Symbols symbols) {
        this.numbers = numbers;
        this.symbols = symbols;
    }

    public int run() {
        int result = numbers.of(0);
        for (int i = 0; i < numbers.getNumbers().size() - 1; i++) {
            result = (int) OperatorEnum.calculate(
                    symbols.of(i)
                    , result
                    , numbers.of(i + 1));
        }
        return result;
    }
}
