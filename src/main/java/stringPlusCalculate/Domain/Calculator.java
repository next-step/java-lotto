package stringPlusCalculate.Domain;


public class Calculator {

    private Calculator() {
    }

    public static Calculator init() {
        return new Calculator();
    }

    public Double calculate(String input, Operator operator) {
        Formula formula = Formula.init(input);
        ArithmeticTargets arithmeticTargets = formula.arithmeticBySplit();
        return operator.calc(arithmeticTargets.toList());
    }
}
