package step1.domain;

public class CalculatingMachine {

    private final Numbers numbers;
    private final Operators operators;


    public CalculatingMachine(Numbers numbers, Operators operators) {
        this.numbers = numbers;
        this.operators = operators;
    }

    public Number calculation() {
        Number number = numbers.pollNumber();

        while (numbers.size() != 1) {
            Number pollNumber = numbers.pollNumber();
            number = calculate(number, operators, pollNumber);
        }
        number = calculate(number, operators, numbers.pollNumber());

        return number;
    }

    private Number calculate(Number number, Operators operators, Number numbers) {
        number = Calculator.findBy(operators.operator())
            .apply(number, numbers);
        return number;
    }
}
