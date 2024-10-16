package step1stringcalculator;

public class Calculator {
    CalculatorString calculatorString;

    public Calculator() {
        this("0");
    }

    public Calculator(String calculatorString) {
        this.calculatorString = new CalculatorString(calculatorString);
    }

    public void checkCalculateString() {
        calculatorString.checkCalculatorExpression();
        calculatorString.checkNonOperator();
        calculatorString.checkNullAndEmpty();
    }

    public int calculate() {
        return calculatorString.calculate();
    }
}
