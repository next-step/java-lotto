package stringPlusCalculate.Domain;


public class Calculator {

    String input;
    Operator operator;

    private Calculator(String input, Operator operator) {
        this.input = input;
        this.operator = operator;
    }

    public static Calculator init(String input, Operator operator) {
        return new Calculator(input, operator);
    }

    public Double calculate() {
        Formula formula = Formula.init(input);
        ArithmeticTargets arithmeticTargets = formula.arithmeticBySplit();
        return operator.calc(arithmeticTargets.toList());
    }
}
