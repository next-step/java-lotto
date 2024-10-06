package stringCalculator.domain;

public class StringCalculator {

    private Number firstNumber;
    private Number secondNumber;
    private Operator operator;

    public StringCalculator(String firstNumber, String secondNumber, String operator) {
        this.firstNumber = new Number(firstNumber);
        this.secondNumber = new Number(secondNumber);
        this.operator = new Operator(operator);
    }

    public int calculate() {
        ArithmeticOperator arithmeticOperator = ArithmeticOperator.from(operator.getOperator());

        return arithmeticOperator.calculate(firstNumber.getNumber(), secondNumber.getNumber());
    }

}
