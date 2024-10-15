package step1stringcalculator;

public class Calculator {
    CalculatorString calculatorString;

    public Calculator() {
        this("0");
    }

    public Calculator(String calculatorString) {
        this.calculatorString = new CalculatorString(calculatorString);
    }


    public int calculate() {
        return calculatorString.calculate();
    }
}
